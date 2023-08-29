package `in`.silive.tifac.domain.repository

import `in`.silive.tifac.data.remote.dto.PlaylistsDto

interface PlaylistRepository {
    suspend fun getPlaylists() : PlaylistsDto
}