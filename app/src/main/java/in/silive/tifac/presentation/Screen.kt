package `in`.silive.tifac.presentation

sealed class Screen(val route: String){
    object AkgecDigitalSchoolScreen: Screen("akgec_digital_school_screen")
    object AkgecSkillsScreen: Screen("akgec_skills_screen")
    object VideosScreen: Screen("videos_screen")
    object PlaylistsScreen: Screen("playlists_screen")
    object OnboardingScreen: Screen("onboarding_screen")
    object SearchScreen: Screen("search_screen")
}
