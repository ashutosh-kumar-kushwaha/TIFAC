package `in`.silive.tifac.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import `in`.silive.tifac.presentation.akgecDigitalSchool.AkgecDigitalSchoolScreen
import `in`.silive.tifac.presentation.onboarding.OnboardingScreen
import `in`.silive.tifac.presentation.ui.theme.TIFACTheme

@AndroidEntryPoint
class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TIFACTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.OnboardingScreen.route) {
        composable(Screen.OnboardingScreen.route) {
            OnboardingScreen {
                navController.navigate(it)
            }
        }
        composable(Screen.AkgecDigitalSchoolScreen.route) {
            AkgecDigitalSchoolScreen()
        }
    }
}