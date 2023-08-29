package `in`.silive.tifac.repository

import android.util.Log
import `in`.silive.tifac.SingleLiveEvent
import `in`.silive.tifac.common.NetworkResult
import `in`.silive.tifac.data.remote.TifacApi
import `in`.silive.tifac.data.remote.dto.PlaylistsResponse
import `in`.silive.tifac.data.remote.dto.VideosDto
import javax.inject.Inject

class AkgecDigitalSchoolRepository @Inject constructor(private val tifacApi: TifacApi){
    val videosResponse = SingleLiveEvent<NetworkResult<VideosDto>>()
    val playlistsResponse = SingleLiveEvent<NetworkResult<PlaylistsResponse>>()

    suspend fun getVideos(){
        videosResponse.value = NetworkResult.Loading()
        try {
            val response = tifacApi.getVideos(1, 10, "publishedAt", "asc")
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
            val response = tifacApi.getPlaylists(1, 10, "publishedAt", "asc")
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