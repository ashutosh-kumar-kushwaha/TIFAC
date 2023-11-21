package `in`.silive.tifac.presentation.akgecDigitalSchool.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.silive.tifac.domain.model.Video
import `in`.silive.tifac.presentation.ui.theme.TextColor4
import `in`.silive.tifac.presentation.ui.theme.gilroy

@Composable
fun VideosScreen(videos: List<Video>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(
                horizontal = 24.dp,
                vertical = 13.dp
            )
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            item {
                Text(
                    text = "Discover",
                    fontSize = 28.sp,
                    fontFamily = gilroy,
                    fontWeight = FontWeight(700),
                    color = TextColor4,
                )
            }
            items(videos.size) { index ->
                VideoItem(videos[index])
            }
        }
    }
}

@Preview
@Composable
fun PreviewVideosScreen() {
//    VideosScreen(videos)
}
