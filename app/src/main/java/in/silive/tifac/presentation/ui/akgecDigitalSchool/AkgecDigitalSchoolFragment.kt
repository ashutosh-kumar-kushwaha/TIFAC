package `in`.silive.tifac.presentation.ui.akgecDigitalSchool

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import `in`.silive.tifac.R
import `in`.silive.tifac.presentation.ui.adapters.ViewPagerAdapter
import `in`.silive.tifac.databinding.FragmentAkgecDigitalSchoolBinding
import java.lang.reflect.Field

@AndroidEntryPoint
class AkgecDigitalSchoolFragment : Fragment() {

    private var _binding : FragmentAkgecDigitalSchoolBinding? = null
    private val binding: FragmentAkgecDigitalSchoolBinding get() = _binding!!

    private val tabsName = listOf("Videos", "Playlists")
    private val tabsIcon = listOf(R.drawable.ic_video, R.drawable.ic_playlist)

    private val akgecDigitalSchoolViewModel by viewModels<AkgecDigitalSchoolViewModel>()

    private var isVideoSelected = true

    @SuppressLint("DiscouragedPrivateApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAkgecDigitalSchoolBinding.inflate(inflater, container, false)

        binding.viewModel = akgecDigitalSchoolViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->
            tab.text = tabsName[position]
            tab.setIcon(tabsIcon[position])
        }.attach()


        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if(isVideoSelected)
                    akgecDigitalSchoolViewModel.getVideos()
                else
                    akgecDigitalSchoolViewModel.getPlaylists()

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(isVideoSelected)
                    akgecDigitalSchoolViewModel.getVideos()
                else
                    akgecDigitalSchoolViewModel.getPlaylists()

                newText.let { akgecDigitalSchoolViewModel.searchText.value = it }
                return true
            }

        })

        val searchText = binding.searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        val font = ResourcesCompat.getFont(requireContext(), R.font.gilroy_medium)
        searchText.typeface = font
        searchText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16F)
        searchText.setHintTextColor(ContextCompat.getColor(requireContext(), R.color.color3))
        searchText.setTextColor(ContextCompat.getColor(requireContext(), R.color.color3))
        searchText.setBackgroundColor(Color.TRANSPARENT)

        if(Build.VERSION.SDK_INT >= 29){
            searchText.textCursorDrawable = AppCompatResources.getDrawable(requireContext(), R.drawable.cursor)
        }
        else{
            try {
                val f: Field = TextView::class.java.getDeclaredField("mCursorDrawableRes")
                f.isAccessible = true
                f.set(searchText, R.drawable.cursor)
            } catch (_: Exception){}
        }

        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                isVideoSelected = !isVideoSelected
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}