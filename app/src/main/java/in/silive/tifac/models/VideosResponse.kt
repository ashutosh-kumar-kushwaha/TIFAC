package `in`.silive.tifac.models

data class VideosResponse(
    val content: List<Video>,
    val lastPage: Boolean,
    val pageNumber: Int,
    val pageSize: Int,
    val totalElements: Int,
    val totalPage: Int
)