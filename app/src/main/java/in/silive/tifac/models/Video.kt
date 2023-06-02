package `in`.silive.tifac.models

data class Video(
    val id: String,
    val publishedAt: String,
    val thumbnails: Thumbnails,
    val title: String,
    val videoId: String
)