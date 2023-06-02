package `in`.silive.tifac.repository

import android.util.Log
import `in`.silive.tifac.SingleLiveEvent
import `in`.silive.tifac.api.NetworkResult
import `in`.silive.tifac.api.RetrofitAPI
import `in`.silive.tifac.models.PlaylistsResponse
import `in`.silive.tifac.models.VideosResponse
import javax.inject.Inject

class AkgecDigitalSchoolRepository @Inject constructor(private val retrofitAPI: RetrofitAPI){
    val videosResponse = SingleLiveEvent<NetworkResult<VideosResponse>>()
    val playlistsResponse = SingleLiveEvent<NetworkResult<PlaylistsResponse>>()

    suspend fun getVideos(){
        videosResponse.value = NetworkResult.Loading()
        try {
            val response = retrofitAPI.getVideos(1, 10, "publishedAt", "asc")
            when(response.code()){
                200 -> {
                    if(response.body()!=null){
                        videosResponse.value = NetworkResult.Success(200, response.body()!!)
                        Log.d("Ashu", "Yo!")
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

    suspend fun getPlaylists(){
        playlistsResponse.value = NetworkResult.Loading()
        try {
            val response = retrofitAPI.getPlaylists(1, 10, "publishedAt", "asc")
            when(response.code()){
                200 -> {
                    if(response.body()!=null){
                        playlistsResponse.value = NetworkResult.Success(200, response.body()!!)
                    }
                    else{
                        playlistsResponse.value = NetworkResult.Error(200, "Something went wrong\nResponse in null")
                    }
                }
                else -> {
                    playlistsResponse.value = NetworkResult.Error(response.code(), "Something went wrong\nError code: ${response.code()}")
                }
            }
        } catch (e: Exception){
            playlistsResponse.value = NetworkResult.Error(-1, e.message)
            e.printStackTrace()
        }
    }
}