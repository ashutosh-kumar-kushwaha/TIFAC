package `in`.silive.tifac.data.repository

import `in`.silive.tifac.data.remote.TifacApi
import `in`.silive.tifac.data.remote.dto.PlaylistsDto
import `in`.silive.tifac.domain.repository.PlaylistRepository
import javax.inject.Inject

class PlaylistRepositoryImpl @Inject constructor(private val tifacApi: TifacApi) : PlaylistRepository {
    override suspend fun getPlaylists(): PlaylistsDto {
        return tifacApi.getPlaylists(1, 10, "publishedAt", "asc")
    }
}