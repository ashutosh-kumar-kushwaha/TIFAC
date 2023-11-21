package `in`.silive.tifac.data.remote.dto

import `in`.silive.tifac.domain.model.Playlist

data class PlaylistDto(
    val id: String,
    val publishedAt: String,
    val thumbnails: Thumbnails,
    val title: String
)

fun PlaylistDto.toPlaylist() =
    Playlist(
        id = id,
        publishedAt = publishedAt,
        title = title,
        thumbnail = thumbnails.high.url
    )