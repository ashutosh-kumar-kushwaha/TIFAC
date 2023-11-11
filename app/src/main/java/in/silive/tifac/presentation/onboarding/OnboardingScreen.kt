package `in`.silive.tifac.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import `in`.silive.tifac.R

@Composable
fun OnboardingScreen() {
    Column(
        modifier = Modifier
            .padding(top = 185.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.akgec_skills_logo),
            contentDescription = "AKGEC Skills Logo",
            modifier = Modifier
                .padding(horizontal = 84.dp),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    OnboardingScreen()
}