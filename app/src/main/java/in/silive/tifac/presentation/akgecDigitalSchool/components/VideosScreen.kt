package `in`.silive.tifac.presentation.akgecDigitalSchool.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import `in`.silive.tifac.domain.model.Video
import `in`.silive.tifac.presentation.ui.theme.TextColor4
import `in`.silive.tifac.presentation.ui.theme.gilroy

@Composable
fun VideosScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Text(
            text = "Discover",
            fontSize = 28.sp,
            fontFamily = gilroy,
            fontWeight = FontWeight(700),
            color = TextColor4,
        )
        val videos = listOf(Video("1", "1 day ago", "", "Hello"), Video("1", "1 day ago", "", "Hello"), Video("1", "1 day ago", "", "Hello"))
        LazyColumn(

        ) {
            items(5) { video ->
                VideoItem()
            }
        }
    }
}

@Preview
@Composable
fun PreviewVideosScreen() {
    VideosScreen()
}
