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
import `in`.silive.tifac.R
import `in`.silive.tifac.presentation.ui.theme.TextColor5
import `in`.silive.tifac.presentation.ui.theme.TextColor6
import `in`.silive.tifac.presentation.ui.theme.gilroy

@Composable
fun VideoItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.sharma_ji),
            contentDescription = "Thumbnail",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f),
            contentScale = ContentScale.FillWidth
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
            Column {
                Text(
                    text = "“Secure Electronic Transaction” Cryptography and Network Security Lecture 03 By Ms Shilpi Gupta",
                    fontFamily = gilroy,
                    fontWeight = FontWeight(500),
                    fontSize = 12.sp,
                    color = TextColor5
                )
                Text(
                    text = "1 days ago",
                    fontFamily = gilroy,
                    fontWeight = FontWeight(500),
                    fontSize = 10.sp,
                    color = TextColor6
                )
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun PreviewVideos() {
    VideoItem()
}