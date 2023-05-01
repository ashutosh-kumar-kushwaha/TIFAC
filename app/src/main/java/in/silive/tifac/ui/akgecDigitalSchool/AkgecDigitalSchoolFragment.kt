package `in`.silive.tifac.ui.akgecDigitalSchool

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import `in`.silive.tifac.adapters.ViewPagerAdapter
import `in`.silive.tifac.databinding.FragmentAkgecDigitalSchoolBinding

class AkgecDigitalSchoolFragment : Fragment() {

    private var _binding : FragmentAkgecDigitalSchoolBinding? = null
    private val binding: FragmentAkgecDigitalSchoolBinding get() = _binding!!

    private val tabs = arrayOf("Videos", "Playlists")

    private val akgecDigitalSchoolViewModel by viewModels<AkgecDigitalSchoolViewModel>()

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

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}