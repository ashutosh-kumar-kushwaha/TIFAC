package `in`.silive.tifac.presentation

sealed class Screen(val route: String){
    object AkgecDigitalSchoolScreen: Screen("akgec_digital_school_screen")
    object VideosScreen: Screen("videos_screen")
    object PlaylistsScreen: Screen("playlists_screen")
    object OnboardingScreen: Screen("onboarding_screen")
}
