package `in`.silive.tifac.presentation.activities.videoPlayer

import android.app.PictureInPictureParams
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Rational
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import dagger.hilt.android.AndroidEntryPoint
import `in`.silive.tifac.R
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
            }
        }

        val iFrameOptions = IFramePlayerOptions.Builder()
            .controls(1)
            .build()

        binding.youtubePlayerView.initialize(youTubePlayerListener, true, iFrameOptions)

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
}