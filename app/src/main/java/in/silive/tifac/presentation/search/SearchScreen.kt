package `in`.silive.tifac.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import `in`.silive.tifac.presentation.search.components.AppBar
import `in`.silive.tifac.presentation.search.components.RecentSearch
import `in`.silive.tifac.presentation.viewModels.SearchViewModel

@Composable
fun SearchScreen(
    viewModel : SearchViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AppBar(
            viewModel.query
        ){
            viewModel.onQueryChange(it)
        }
        RecentSearch()
    }
}

@Preview
@Composable
fun PreviewSearchScreen() {
    SearchScreen()
}