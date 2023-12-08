package `in`.silive.tifac.presentation.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.silive.tifac.presentation.ui.theme.TextColor4
import `in`.silive.tifac.presentation.ui.theme.gilroy

@Composable
fun RecentSearch() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(24.dp)
    ) {
        Text(
            text = "Your Recent Search",
            fontSize = 20.sp,
            fontFamily = gilroy,
            fontWeight = FontWeight(700),
            color = TextColor4,
        )
    }
}

@Preview
@Composable
fun PreviewRecentSearch() {
    RecentSearch()
}