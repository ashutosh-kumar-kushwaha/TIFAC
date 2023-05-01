package `in`.silive.tifac.ui.akgecDigitalSchool

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import `in`.silive.tifac.repository.AkgecDigitalSchoolRepository
import kotlinx.coroutines.launch

class AkgecDigitalSchoolViewModel(private val akgecDigitalSchoolRepository: AkgecDigitalSchoolRepository): ViewModel() {
    val videosReponse get() = akgecDigitalSchoolRepository.videosResponse

    fun getVideos(searchText: String){
        viewModelScope.launch {
            akgecDigitalSchoolRepository.getVideos(searchText)
        }
    }
}