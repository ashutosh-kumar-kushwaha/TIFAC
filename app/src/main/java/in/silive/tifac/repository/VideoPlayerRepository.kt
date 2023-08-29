package `in`.silive.tifac.repository

import `in`.silive.tifac.SingleLiveEvent
import `in`.silive.tifac.common.NetworkResult
import `in`.silive.tifac.data.remote.TifacApi
import `in`.silive.tifac.data.remote.dto.VideoDto
import javax.inject.Inject

class VideoPlayerRepository @Inject constructor(private val tifacApi: TifacApi) {
    val videoDetails = SingleLiveEvent<NetworkResult<VideoDto>>()

    suspend fun getVideoDetails(videoId: String){
        videoDetails.value = NetworkResult.Loading()
        try {
            val response = tifacApi.getVideoDetails(videoId)
            when(response.code()){
                200 -> {
                    if(response.body()!=null){
                        videoDetails.value = NetworkResult.Success(200, response.body()!!)
                    }
                    else{
                        videoDetails.value = NetworkResult.Error(200, "Something went wrong\nResponse in null")
                    }
                }
                else -> {
                    videoDetails.value = NetworkResult.Error(response.code(), "Something went wrong\nError code: ${response.code()}")
                }
            }
        } catch (e: Exception){
            e.printStackTrace()
            videoDetails.value = NetworkResult.Error(-1, e.message)
        }
    }
}