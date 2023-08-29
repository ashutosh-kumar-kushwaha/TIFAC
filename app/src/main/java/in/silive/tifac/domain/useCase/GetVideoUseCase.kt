package `in`.silive.tifac.domain.useCase

import `in`.silive.tifac.common.NetworkResult
import `in`.silive.tifac.data.remote.dto.toVideo
import `in`.silive.tifac.domain.model.Video
import `in`.silive.tifac.domain.repository.VideoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetVideoUseCase @Inject constructor(private val videoRepository: VideoRepository){
    suspend fun invoke(id: String) : Flow<NetworkResult<Video>> = flow{
        emit(NetworkResult.Loading())
        try {
            val video = videoRepository.getVideoById(id).toVideo()
            emit(NetworkResult.Success(video))
        } catch (e: HttpException) {
            emit(NetworkResult.Error(e.localizedMessage ?: "An unexpected error occurred\nResponse code: ${e.code()}"))
        } catch (e: Exception){
            emit(NetworkResult.Error("Couldn't reach the server\nCheck your internet connection"))
        }
    }
}