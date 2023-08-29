package `in`.silive.tifac.domain.repository

import `in`.silive.tifac.data.remote.dto.VideoDto
import `in`.silive.tifac.data.remote.dto.VideosDto

interface VideoRepository {
    suspend fun getVideos(): VideosDto
    suspend fun getVideoById(id: String): VideoDto
}