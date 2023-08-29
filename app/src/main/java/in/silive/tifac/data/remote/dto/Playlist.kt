package `in`.silive.tifac.data.remote.dto

import `in`.silive.tifac.data.remote.dto.Thumbnails

data class Playlist(
    val id: String,
    val publishedAt: String,
    val thumbnails: Thumbnails,
    val title: String
)