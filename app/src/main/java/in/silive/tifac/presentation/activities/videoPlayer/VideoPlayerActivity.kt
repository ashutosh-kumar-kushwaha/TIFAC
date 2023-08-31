package `in`.silive.tifac.presentation.activities.videoPlayer

import android.app.PictureInPictureParams
import android.content.pm.ActivityInfo
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.Rational
import android.view.View
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.pierfrancescosoffritti.androidyoutubeplayer.core.customui.DefaultPlayerUiController
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import dagger.hilt.android.AndroidEntryPoint
import `in`.silive.tifac.R
import `in`.silive.tifac.common.Utils.hide
import `in`.silive.tifac.common.Utils.show
import `in`.silive.tifac.databinding.ActivityVideoBinding
import `in`.silive.tifac.presentation.viewModels.VideoPlayerViewModel


@AndroidEntryPoint
class VideoPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoBinding
    private val videoPlayerViewModel by viewModels<VideoPlayerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video)

        if(videoPlayerViewModel.id == "") videoPlayerViewModel.id =
            intent.getStringExtra("id").toString()

        lifecycle.addObserver(binding.youtubePlayerView)

        val youTubePlayerListener = object : AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoPlayerViewModel.id, 0F)
                val defaultPlayerUiController =
                    DefaultPlayerUiController(binding.youtubePlayerView, youTubePlayer)

                binding.youtubePlayerView.setCustomPlayerUi(defaultPlayerUiController.rootView)
            }
        }

        val iFrameOptions = IFramePlayerOptions.Builder()
            .controls(0)
            .fullscreen(1)
            .build()

        binding.youtubePlayerView.initialize(youTubePlayerListener, true, iFrameOptions)

        binding.youtubePlayerView.addFullscreenListener(object: FullscreenListener{
            override fun onEnterFullscreen(fullscreenView: View, exitFullscreen: () -> Unit) {
                Log.d("Ashu", "onEnterFullscreen: ")
                window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                hideViews()
            }

            override fun onExitFullscreen() {
                Log.d("Ashu", "onExitFullscreen: ")
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                showViews()
            }

        })

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onUserLeaveHint() {
        super.onUserLeaveHint()
        enterPictureInPictureMode(PictureInPictureParams.Builder()
                .setAspectRatio(Rational(16,9))
                .build())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBackPressed() {
        enterPictureInPictureMode(PictureInPictureParams.Builder()
                .setAspectRatio(Rational(16,9))
                .build())
    }

    fun hideViews(){
        binding.toolbar.hide()
        binding.bg1.hide()
        binding.bg2.hide()
        binding.tvVideoName.hide()
        binding.imgAkgecLogo.hide()
        binding.tvNoOfVideos.hide()
        binding.tvRecommended.hide()
        binding.rvRecommendation.hide()
    }

    fun showViews(){
        binding.toolbar.show()
        binding.bg1.show()
        binding.bg2.show()
        binding.tvVideoName.show()
        binding.imgAkgecLogo.show()
        binding.tvNoOfVideos.show()
        binding.tvRecommended.show()
        binding.rvRecommendation.show()
    }
}
