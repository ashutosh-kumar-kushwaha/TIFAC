package `in`.silive.tifac.data.remote

import `in`.silive.tifac.data.remote.dto.PlaylistsDto
import `in`.silive.tifac.data.remote.dto.VideoDto
import `in`.silive.tifac.data.remote.dto.VideosDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TifacApi {
    @GET("api/youtube/getAllVideos")
    suspend fun getVideos(@Query("pageNumber") pageNumber: Int, @Query("pageSize") pageSize: Int, @Query("sortBy") sortBy: String, @Query("sortDir") sortDir: String): VideosDto

    @GET("api/youtube/getAllPlayLists")
    suspend fun getPlaylists(@Query("pageNumber") pageNumber: Int, @Query("pageSize") pageSize: Int, @Query("sortBy") sortBy: String, @Query("sortDir") sortDir: String): PlaylistsDto

    @GET("api/youtube/getVideoById/{videoId}")
    suspend fun getVideoById(@Path("videoId") videoId: String) : VideoDto
}