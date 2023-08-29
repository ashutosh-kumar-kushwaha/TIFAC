package `in`.silive.tifac.data.remote.dto

data class VideosDto(
    val content: List<VideoItem>,
    val lastPage: Boolean,
    val pageNumber: Int,
    val pageSize: Int,
    val totalElements: Int,
    val totalPage: Int
)