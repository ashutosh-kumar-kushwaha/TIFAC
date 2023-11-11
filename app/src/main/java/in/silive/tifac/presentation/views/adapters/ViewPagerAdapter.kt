package `in`.silive.tifac.presentation.views.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import `in`.silive.tifac.presentation.views.fragments.playlists.PlaylistsFragment
import `in`.silive.tifac.presentation.views.fragments.videos.VideosFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if(position == 0){
            VideosFragment()
        } else{
            PlaylistsFragment()
        }
    }
}