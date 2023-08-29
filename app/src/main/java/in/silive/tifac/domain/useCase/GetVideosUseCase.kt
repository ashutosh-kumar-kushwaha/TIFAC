package `in`.silive.tifac.domain.useCase

import `in`.silive.tifac.common.NetworkResult
import `in`.silive.tifac.data.remote.dto.toVideo
import `in`.silive.tifac.domain.model.Video
import `in`.silive.tifac.domain.repository.VideoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetVideosUseCase @Inject constructor(private val videoRepository: VideoRepository){
    suspend fun invoke() : Flow<NetworkResult<List<Video>>> = flow{
        emit(NetworkResult.Loading())
        try {
            val videos = videoRepository.getVideos().content.map { it.toVideo() }
            emit(NetworkResult.Success(videos))
        } catch (e: HttpException) {
            emit(NetworkResult.Error(e.localizedMessage ?: "An unexpected error occurred\nResponse code: ${e.code()}"))
        } catch (e: Exception){
            emit(NetworkResult.Error("Couldn't reach the server\nCheck your internet connection"))
        }
    }
}