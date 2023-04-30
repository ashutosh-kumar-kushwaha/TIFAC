package `in`.silive.tifac.ui.akgecDigitalSchool

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `in`.silive.tifac.databinding.FragmentAkgecDigitalSchoolBinding

class AkgecDigitalSchoolFragment : Fragment() {

    private var _binding : FragmentAkgecDigitalSchoolBinding? = null
    private val binding: FragmentAkgecDigitalSchoolBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAkgecDigitalSchoolBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}