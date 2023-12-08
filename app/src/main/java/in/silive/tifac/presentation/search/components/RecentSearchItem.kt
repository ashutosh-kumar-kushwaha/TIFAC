package `in`.silive.tifac.presentation.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.silive.tifac.R
import `in`.silive.tifac.presentation.ui.theme.TextColor3
import `in`.silive.tifac.presentation.ui.theme.gilroy

@Composable
fun RecentSearchItem() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 4.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search Icon",
            modifier = Modifier
                .width(20.dp)
                .height(20.dp),
            tint = Color(0xFF212031)
        )
        Text(
            text = "Mr. Sharma Ji",
            fontSize = 16.sp,
                fontFamily = gilroy,
                fontWeight = FontWeight(500),
                color = TextColor3,
        )
    }
}

@Preview
@Composable
fun PreviewRecentSearchItem() {
    RecentSearchItem()
}