package `in`.silive.tifac.repository

import android.util.Log
import `in`.silive.tifac.SingleLiveEvent
import `in`.silive.tifac.api.NetworkResult
import `in`.silive.tifac.api.RetrofitAPI
import `in`.silive.tifac.models.VideoDetails
import javax.inject.Inject

class VideoPlayerRepository @Inject constructor(private val retrofitAPI: RetrofitAPI) {
    val videoDetails = SingleLiveEvent<NetworkResult<VideoDetails>>()

    suspend fun getVideoDetails(videoId: String){
        videoDetails.value = NetworkResult.Loading()
        try {
            val response = retrofitAPI.getVideoDetails(videoId)
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