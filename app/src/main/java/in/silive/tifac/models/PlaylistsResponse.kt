package `in`.silive.tifac.models

data class PlaylistsResponse(
    val content: List<Playlist>,
    val lastPage: Boolean,
    val pageNumber: Int,
    val pageSize: Int,
    val totalElements: Int,
    val totalPage: Int
)