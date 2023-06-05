package `in`.silive.tifac.ui.videoPlayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import `in`.silive.tifac.R
import `in`.silive.tifac.databinding.ActivityVideoBinding

class VideoPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVideoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video)
    }
}