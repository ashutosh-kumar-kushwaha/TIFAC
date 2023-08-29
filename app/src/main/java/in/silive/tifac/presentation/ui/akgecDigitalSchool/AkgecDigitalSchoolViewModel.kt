package `in`.silive.tifac.presentation.ui.akgecDigitalSchool

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.silive.tifac.common.NetworkResult
import `in`.silive.tifac.data.remote.dto.Playlist
import `in`.silive.tifac.domain.model.Video
import `in`.silive.tifac.domain.useCase.GetPlaylistsUseCase
import `in`.silive.tifac.domain.useCase.GetVideosUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AkgecDigitalSchoolViewModel @Inject constructor(
    private val getVideosUseCase: GetVideosUseCase,
    private val getPlaylistsUseCase: GetPlaylistsUseCase
): ViewModel() {

    private val _videos = MutableStateFlow<List<Video>>(emptyList())
    val videos = _videos.asStateFlow()

    private val _playlists = MutableStateFlow<List<Playlist>>(emptyList())
    val playlists = _playlists.asStateFlow()

    private val _isVideosLoading = MutableSharedFlow<Boolean>()
    val isVideosLoading = _isVideosLoading.asSharedFlow()

    private val _isPlaylistsLoading = MutableSharedFlow<Boolean>()
    val isPlaylistsLoading = _isPlaylistsLoading.asSharedFlow()

    private val _videosErrorMessage = Channel<String>()
    val videosErrorMessage = _videosErrorMessage.receiveAsFlow()

    private val _playlistsErrorMessage = Channel<String>()
    val playlistsErrorMessage = _playlistsErrorMessage.receiveAsFlow()


    val searchText = MutableLiveData("")

    fun getVideos(){
        viewModelScope.launch {
            getVideosUseCase().onEach {
                when(it){
                    is NetworkResult.Success -> {
                        _videos.emit(it.data!!)
                        _isVideosLoading.emit(false)
                    }
                    is NetworkResult.Error -> {
                        _videosErrorMessage.send(it.message!!)
                        _isVideosLoading.emit(false)
                    }
                    is NetworkResult.Loading -> {
                        _isVideosLoading.emit(true)
                    }
                }
            }
        }
    }

    fun getPlaylists(){
        viewModelScope.launch {
            getPlaylistsUseCase().onEach {
                when(it){
                    is NetworkResult.Success -> {
                        _playlists.emit(it.data!!)
                        _isPlaylistsLoading.emit(false)
                    }
                    is NetworkResult.Error -> {
                        _playlistsErrorMessage.send(it.message!!)
                        _isPlaylistsLoading.emit(false)
                    }
                    is NetworkResult.Loading -> {
                        _isPlaylistsLoading.emit(true)
                    }
                }
            }
        }
    }
}