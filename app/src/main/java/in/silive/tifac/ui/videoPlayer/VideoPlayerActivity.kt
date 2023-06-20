package `in`.silive.tifac.ui.videoPlayer

import android.app.PictureInPictureParams
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Rational
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import `in`.silive.tifac.R
import `in`.silive.tifac.databinding.ActivityVideoBinding

class VideoPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video)
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