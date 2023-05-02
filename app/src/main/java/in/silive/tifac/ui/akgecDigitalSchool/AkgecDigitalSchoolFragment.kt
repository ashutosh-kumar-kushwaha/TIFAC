package `in`.silive.tifac.ui.akgecDigitalSchool

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import `in`.silive.tifac.R
import `in`.silive.tifac.adapters.ViewPagerAdapter
import `in`.silive.tifac.databinding.FragmentAkgecDigitalSchoolBinding
import java.lang.reflect.Field

@AndroidEntryPoint
class AkgecDigitalSchoolFragment : Fragment() {

    private var _binding : FragmentAkgecDigitalSchoolBinding? = null
    private val binding: FragmentAkgecDigitalSchoolBinding get() = _binding!!

    private val tabs = arrayOf("Videos", "Playlists")

    private val akgecDigitalSchoolViewModel by viewModels<AkgecDigitalSchoolViewModel>()

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
            tab.text = tabs[position]
        }.attach()

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                akgecDigitalSchoolViewModel.getVideos(query.toString())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                akgecDigitalSchoolViewModel.getVideos(newText.toString())
                return true
            }

        })

        val searchText = binding.searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        val font = ResourcesCompat.getFont(requireContext(), R.font.gilroy_medium)
        searchText.typeface = font
        searchText.setHintTextColor(ContextCompat.getColor(requireContext(), R.color.color9))
        searchText.setTextColor(ContextCompat.getColor(requireContext(), R.color.color9))

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

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}