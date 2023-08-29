package `in`.silive.tifac.data.remote.dto

import `in`.silive.tifac.domain.model.Video

data class VideoItem(
    val id: String,
    val publishedAt: String,
    val thumbnails: Thumbnails,
    val title: String,
    val videoId: String
)

fun VideoItem.toVideo(): Video {
    return Video(
        id = videoId,
        publishedAt = publishedAt,
        thumbnail = thumbnails.high.url,
        title = title
    )
}