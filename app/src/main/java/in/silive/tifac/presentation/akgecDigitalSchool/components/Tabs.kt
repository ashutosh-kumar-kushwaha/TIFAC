package `in`.silive.tifac.presentation.akgecDigitalSchool.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.silive.tifac.R
import `in`.silive.tifac.presentation.ui.theme.BGColor2
import `in`.silive.tifac.presentation.ui.theme.TextColor3
import `in`.silive.tifac.presentation.ui.theme.gilroy

@Composable
fun Tabs() {
    val titles = listOf("Videos", "Playlists")
    val icons = listOf(R.drawable.ic_video, R.drawable.ic_playlist)
    var selectedIndex by remember { mutableIntStateOf(0) }

    TabRow(
        selectedTabIndex = selectedIndex,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(4.dp)
            ),
        indicator = {},
        divider = {}
    ) {
        titles.forEachIndexed { index, title ->
            Tab(
                selected = selectedIndex == titles.indexOf(title),
                onClick = {
                    selectedIndex = index
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(
                        color = if (selectedIndex == index) BGColor2 else Color.Transparent,
                        shape = RoundedCornerShape(4.dp)
                    )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = icons[index]),
                        contentDescription = null,
                        modifier = Modifier
                            .width(24.dp)
                            .padding(end = 4.dp)
                    )
                    Text(
                        text = title,
                        fontSize = 16.sp,
                        fontFamily = gilroy,
                        fontWeight = FontWeight(600),
                        color = TextColor3,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    Tabs()
}