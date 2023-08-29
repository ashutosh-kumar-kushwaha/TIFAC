package `in`.silive.tifac.data.repository

import `in`.silive.tifac.data.remote.TifacApi
import `in`.silive.tifac.data.remote.dto.VideoDto
import `in`.silive.tifac.data.remote.dto.VideosDto
import `in`.silive.tifac.domain.repository.VideoRepository
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(private val tifacApi: TifacApi) : VideoRepository {
    override suspend fun getVideos(): VideosDto {
        return tifacApi.getVideos(1, 10, "publishedAt", "asc")
    }

    override suspend fun getVideoById(id: String): VideoDto {
        return tifacApi.getVideoById(id)
    }
}