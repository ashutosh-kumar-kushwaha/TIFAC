package `in`.silive.tifac.models

data class VideoDetails(
    val description: String,
    val etag: String,
    val id: String,
    val playLists: List<Any>,
    val publishedAt: String,
    val thumbnails: Thumbnails,
    val title: String,
    val videoId: String
)