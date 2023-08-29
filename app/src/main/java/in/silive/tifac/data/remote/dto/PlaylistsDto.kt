package `in`.silive.tifac.data.remote.dto

data class PlaylistsDto(
    val content: List<Playlist>,
    val lastPage: Boolean,
    val pageNumber: Int,
    val pageSize: Int,
    val totalElements: Int,
    val totalPage: Int
)