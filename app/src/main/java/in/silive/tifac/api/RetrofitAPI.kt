package `in`.silive.tifac.api

import `in`.silive.tifac.models.PlaylistsResponse
import `in`.silive.tifac.models.VideosResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitAPI {
    @GET("search")
    suspend fun getVideos(@Query("q") searchText: String, @Query("type") type: String="video", @Query("part") part: String="snippet", @Query("maxResults") maxResults: Int = 10): Response<VideosResponse>

    @GET("search")
    suspend fun getPlaylists(@Query("q") searchText: String, @Query("type") type: String="playlist", @Query("part") part: String="snippet", @Query("maxResults") maxResults: Int = 10): Response<PlaylistsResponse>

}