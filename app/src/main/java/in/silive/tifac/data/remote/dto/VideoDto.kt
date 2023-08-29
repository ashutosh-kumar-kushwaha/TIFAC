package `in`.silive.tifac.data.remote.dto

import `in`.silive.tifac.domain.model.Video

data class VideoDto(
    val description: String,
    val etag: String,
    val id: String,
    val playLists: List<Any>,
    val publishedAt: String,
    val thumbnails: Thumbnails,
    val title: String,
    val videoId: String
)

fun VideoDto.toVideo() : Video {
    return Video(
        id = videoId,
        publishedAt = publishedAt,
        thumbnail = thumbnails.high.url,
        title = title
    )
}