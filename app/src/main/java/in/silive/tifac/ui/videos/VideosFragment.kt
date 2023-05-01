package `in`.silive.tifac.ui.videos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import `in`.silive.tifac.databinding.FragmentVideosBinding
import `in`.silive.tifac.ui.akgecDigitalSchool.AkgecDigitalSchoolViewModel

@AndroidEntryPoint
class VideosFragment : Fragment() {

    private var _binding : FragmentVideosBinding? = null
    private val binding: FragmentVideosBinding get() = _binding!!

    private val akgecDigitalSchoolViewModel by viewModels<AkgecDigitalSchoolViewModel>({requireParentFragment()})

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        akgecDigitalSchoolViewModel.videosResponse.observe(viewLifecycleOwner){
            Log.d("Video Fragment", it.data.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}