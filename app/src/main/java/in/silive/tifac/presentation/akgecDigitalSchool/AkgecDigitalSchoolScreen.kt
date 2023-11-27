package `in`.silive.tifac.presentation.akgecDigitalSchool

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import `in`.silive.tifac.presentation.akgecDigitalSchool.components.AppBar
import `in`.silive.tifac.presentation.akgecDigitalSchool.components.PlaylistsScreen
import `in`.silive.tifac.presentation.akgecDigitalSchool.components.VideosScreen
import `in`.silive.tifac.presentation.viewModels.AkgecDigitalSchoolViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AkgecDigitalSchoolScreen(
    viewModel: AkgecDigitalSchoolViewModel = hiltViewModel()
) {
    val videos = viewModel.videos.collectAsStateWithLifecycle()
    val playlists = viewModel.playlists.collectAsStateWithLifecycle()

    val pagerState = rememberPagerState {
        2
    }

    var selectedTabIndex by remember { mutableIntStateOf(0) }

    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            AppBar(
                selectedTabIndex = selectedTabIndex,
            ){
                coroutineScope.launch {
                    pagerState.animateScrollToPage(it)
                }
            }
        },
        modifier = Modifier
            .background(
                color = Color.White
            )
    ) {

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .padding(it)
        ) {page ->
            when(page){
                0 -> {
                    VideosScreen(videos.value)
                    selectedTabIndex = 0
                }
                1 -> {
                    PlaylistsScreen(playlists.value)
                    selectedTabIndex = 1
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    AkgecDigitalSchoolScreen()
}