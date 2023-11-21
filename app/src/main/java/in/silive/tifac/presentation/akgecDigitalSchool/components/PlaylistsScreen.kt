package `in`.silive.tifac.presentation.akgecDigitalSchool.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.silive.tifac.domain.model.Playlist
import `in`.silive.tifac.presentation.Screen
import `in`.silive.tifac.presentation.ui.theme.TextColor4
import `in`.silive.tifac.presentation.ui.theme.gilroy

@Composable
fun PlaylistsScreen(playlists: List<Playlist>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        item {
            Text(
                text = "Playlist",
                fontSize = 28.sp,
                fontFamily = gilroy,
                fontWeight = FontWeight(700),
                color = TextColor4,
            )
        }
        items(playlists.size) { index ->
            PlaylistItem(playlists[index])
        }
    }
}