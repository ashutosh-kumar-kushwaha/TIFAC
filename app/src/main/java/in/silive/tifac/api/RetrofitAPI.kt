package `in`.silive.tifac.api

import `in`.silive.tifac.models.PlaylistsResponse
import `in`.silive.tifac.models.VideoDetails
import `in`.silive.tifac.models.VideosResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitAPI {
    @GET("api/youtube/getAllVideos")
    suspend fun getVideos(@Query("pageNumber") pageNumber: Int, @Query("pageSize") pageSize: Int, @Query("sortBy") sortBy: String, @Query("sortDir") sortDir: String): Response<VideosResponse>

    @GET("api/youtube/getAllPlayLists")
    suspend fun getPlaylists(@Query("pageNumber") pageNumber: Int, @Query("pageSize") pageSize: Int, @Query("sortBy") sortBy: String, @Query("sortDir") sortDir: String): Response<PlaylistsResponse>

    @GET("api/youtube/getVideoById/{videoId}")
    suspend fun getVideoDetails(@Path("videoId") videoId: String) : Response<VideoDetails>
}