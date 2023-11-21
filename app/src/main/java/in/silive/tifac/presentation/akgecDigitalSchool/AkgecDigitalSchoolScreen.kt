package `in`.silive.tifac.presentation.akgecDigitalSchool

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import `in`.silive.tifac.presentation.akgecDigitalSchool.components.AppBar
import `in`.silive.tifac.presentation.akgecDigitalSchool.components.VideosScreen

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun AkgecDigitalSchoolScreen() {
    Scaffold(
        topBar = {
            AppBar()
        },
        modifier = Modifier
            .background(
                color = Color.White
            )
    ) {

        val pagerState = rememberPagerState {
            2
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .padding(it)
        ) {page ->
            when(page){
                0 -> {
                    VideosScreen()
                }
                1 -> {

                }
            }
        }
    }
}

@Preview
@Composable
fun preview() {
    AkgecDigitalSchoolScreen()
}