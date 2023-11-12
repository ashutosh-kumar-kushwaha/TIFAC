package `in`.silive.tifac.presentation.akgecDigitalSchool

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import `in`.silive.tifac.presentation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AkgecDigitalSchoolScreen() {
    Scaffold (
        topBar = {
            TopAppBar(title = { /*TODO*/ })
        }
    ){
        Column(
            modifier = Modifier.padding(it)
        ) {

        }

    }
}

@Preview
@Composable
fun preview(){
    AkgecDigitalSchoolScreen()
}