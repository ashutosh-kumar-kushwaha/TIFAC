package `in`.silive.tifac.presentation.akgecDigitalSchool.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import `in`.silive.tifac.R
import `in`.silive.tifac.common.time.TimesAgoFormat
import `in`.silive.tifac.domain.model.Playlist
import `in`.silive.tifac.presentation.ui.theme.TextColor5
import `in`.silive.tifac.presentation.ui.theme.TextColor6
import `in`.silive.tifac.presentation.ui.theme.gilroy

@Composable
fun PlaylistItem(playlist: Playlist) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AsyncImage(
            model = playlist,
            contentDescription = "Thumbnail",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f),
            contentScale = ContentScale.FillWidth,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.akgec_logo),
                contentDescription = "AKGEC Logo",
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp),
                contentScale = ContentScale.FillWidth
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = playlist.title,
                    fontFamily = gilroy,
                    fontWeight = FontWeight(500),
                    fontSize = 12.sp,
                    color = TextColor5,
                    lineHeight = 15.sp
                )
                Text(
                    text = TimesAgoFormat().getTimeDifference(playlist.publishedAt.substring(0,11)),
                    fontFamily = gilroy,
                    fontWeight = FontWeight(500),
                    fontSize = 10.sp,
                    color = TextColor6
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewPlaylist(){
    PlaylistItem(playlist = Playlist(
        "1",
        "1 days ago",
        "",
        "“Secure Electronic Transaction” Cryptography and Network Security Lecture 03 By Ms Shilpi Gupta"
    )
    )
}