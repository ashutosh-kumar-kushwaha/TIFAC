package `in`.silive.tifac.domain.useCase

import `in`.silive.tifac.common.NetworkResult
import `in`.silive.tifac.data.remote.dto.toPlaylist
import `in`.silive.tifac.domain.model.Playlist
import `in`.silive.tifac.domain.repository.PlaylistRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetPlaylistsUseCase @Inject constructor(private val playlistRepository: PlaylistRepository) {
    operator fun invoke(): Flow<NetworkResult<List<Playlist>>> = flow {
        emit(NetworkResult.Loading())
        try {
            val playlists = playlistRepository.getPlaylists().content.map {
                it.toPlaylist()
            }
            emit(NetworkResult.Success(playlists))
        } catch (e: HttpException) {
            emit(NetworkResult.Error(e.localizedMessage ?: "An unexpected error occurred\nResponse code: ${e.code()}"))
        } catch (e: Exception){
            emit(NetworkResult.Error("Couldn't reach the server\nCheck your internet connection"))
        }
    }
}