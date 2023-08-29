package `in`.silive.tifac.presentation.ui.akgecDigitalSchool

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.silive.tifac.repository.AkgecDigitalSchoolRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AkgecDigitalSchoolViewModel @Inject constructor(private val akgecDigitalSchoolRepository: AkgecDigitalSchoolRepository): ViewModel() {
    val videosResponse get() = akgecDigitalSchoolRepository.videosResponse
    val playlistsResponse get() = akgecDigitalSchoolRepository.playlistsResponse

    val searchText = MutableLiveData("")

    fun getVideos(){
        viewModelScope.launch {
            akgecDigitalSchoolRepository.getVideos()
        }
    }

    fun getPlaylists(){
        viewModelScope.launch {
            akgecDigitalSchoolRepository.getPlaylists()
        }
    }
}