package `in`.silive.tifac.presentation.akgecDigitalSchool.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import `in`.silive.tifac.presentation.ui.theme.BGColor3
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
        ) {
            AsyncImage(
                model = playlist.thumbnail,
                contentDescription = "Thumbnail",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillWidth,
            )
            Column(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .fillMaxWidth(0.4f)
                    .fillMaxHeight()
                    .background(color = BGColor3),
                verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_playlist_white),
                    contentDescription = "Playlist Icon",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp)
                )
            }
        }
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
                    text = TimesAgoFormat().getTimeDifference(
                        playlist.publishedAt.substring(
                            0,
                            11
                        )
                    ),
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
fun PreviewPlaylist() {
//    PlaylistItem()
}