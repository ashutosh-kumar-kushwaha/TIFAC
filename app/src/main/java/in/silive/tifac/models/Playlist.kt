package `in`.silive.tifac.models

data class Playlist(
    val id: String,
    val publishedAt: String,
    val thumbnails: Thumbnails,
    val title: String
)