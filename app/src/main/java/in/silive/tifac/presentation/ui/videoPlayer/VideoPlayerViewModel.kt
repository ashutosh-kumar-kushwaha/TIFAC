package `in`.silive.tifac.presentation.ui.videoPlayer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.silive.tifac.common.NetworkResult
import `in`.silive.tifac.domain.model.Video
import `in`.silive.tifac.domain.useCase.GetVideoUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoPlayerViewModel @Inject constructor(
    private val getVideoUseCase: GetVideoUseCase
): ViewModel() {
    private val _video = MutableStateFlow<Video?>(null)
    val video = _video.asStateFlow()

    private val _errorMessage = Channel<String>()
    val errorMessage = _errorMessage.receiveAsFlow()

    var id = ""

    fun getVideoById(){
        viewModelScope.launch {
            getVideoUseCase(id).onEach {
                when(it){
                    is NetworkResult.Success -> {
                        _video.emit(it.data!!)
                    }
                    is NetworkResult.Error -> {
                        _errorMessage.send(it.message!!)
                    }
                    is NetworkResult.Loading -> {

                    }
                }
            }
        }
    }
}