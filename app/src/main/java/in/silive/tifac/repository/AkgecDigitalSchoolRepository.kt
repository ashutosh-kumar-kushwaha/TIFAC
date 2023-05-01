package `in`.silive.tifac.repository

import `in`.silive.tifac.SingleLiveEvent
import `in`.silive.tifac.api.NetworkResult
import `in`.silive.tifac.api.RetrofitAPI
import `in`.silive.tifac.models.VideosResponse
import javax.inject.Inject

class AkgecDigitalSchoolRepository @Inject constructor(private val retrofitAPI: RetrofitAPI){
    val videosResponse = SingleLiveEvent<NetworkResult<VideosResponse>>()

    suspend fun getVideos(searchText: String){
        videosResponse.value = NetworkResult.Loading()
        try {
            val response = retrofitAPI.getVideos(searchText)
            when(response.code()){
                200 -> {
                    if(response.body()!=null){
                        videosResponse.value = NetworkResult.Success(200, response.body()!!)
                    }
                    else{
                        videosResponse.value = NetworkResult.Error(200, "Something went wrong\nResponse in null")
                    }
                }
                else -> {
                    videosResponse.value = NetworkResult.Error(response.code(), "Something went wrong\nError code: ${response.code()}")
                }
            }
        } catch (e: Exception){
            videosResponse.value = NetworkResult.Error(-1, e.message)
            e.printStackTrace()
        }
    }
}