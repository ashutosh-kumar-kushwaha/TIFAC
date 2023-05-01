package `in`.silive.tifac.ui.akgecDigitalSchool

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.silive.tifac.repository.AkgecDigitalSchoolRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AkgecDigitalSchoolViewModel @Inject constructor(private val akgecDigitalSchoolRepository: AkgecDigitalSchoolRepository): ViewModel() {
    val videosResponse get() = akgecDigitalSchoolRepository.videosResponse

    fun getVideos(searchText: String){
        viewModelScope.launch {
            akgecDigitalSchoolRepository.getVideos(searchText)
        }
    }
}