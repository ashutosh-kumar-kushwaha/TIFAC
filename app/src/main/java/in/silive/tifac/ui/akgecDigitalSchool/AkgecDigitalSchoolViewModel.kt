package `in`.silive.tifac.ui.akgecDigitalSchool

import androidx.lifecycle.LiveData
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
    val playlistsResponse get() = akgecDigitalSchoolRepository.videosResponse

    val searchText = MutableLiveData("")

    fun getVideos(){
        viewModelScope.launch {
            akgecDigitalSchoolRepository.getVideos(searchText.value!!)
        }
    }

    fun getPlaylists(){
        viewModelScope.launch {
            akgecDigitalSchoolRepository.getPlaylists(searchText.value!!)
        }
    }
}