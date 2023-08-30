package `in`.silive.tifac.presentation.fragments.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import `in`.silive.tifac.R
import `in`.silive.tifac.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    private var _binding : FragmentSplashBinding? = null
    private val binding : FragmentSplashBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        binding.akgecSkillsBtn.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_akgecSkillsFragment)
        }
        binding.akgecDigitalSchoolBtn.setOnClickListener{
            findNavController().navigate(R.id.action_splashFragment_to_akgecDigitalSchoolFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}