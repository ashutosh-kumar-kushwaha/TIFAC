package `in`.silive.tifac.ui.videoPlayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.silive.tifac.repository.VideoPlayerRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoPlayerViewModel @Inject constructor(private val videoPlayerRepository: VideoPlayerRepository): ViewModel() {
    val videoDetails get() = videoPlayerRepository.videoDetails

    var videoId = ""

    fun getVideoDetails(){
        viewModelScope.launch {
            videoPlayerRepository.getVideoDetails(videoId)
        }
    }
}