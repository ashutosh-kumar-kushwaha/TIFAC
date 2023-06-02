package `in`.silive.tifac.ui.videos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import `in`.silive.tifac.adapters.VideosRecyclerAdapter
import `in`.silive.tifac.api.NetworkResult
import `in`.silive.tifac.databinding.FragmentVideosBinding
import `in`.silive.tifac.ui.akgecDigitalSchool.AkgecDigitalSchoolViewModel

@AndroidEntryPoint
class VideosFragment : Fragment() {

    private var _binding : FragmentVideosBinding? = null
    private val binding: FragmentVideosBinding get() = _binding!!

    private val akgecDigitalSchoolViewModel by viewModels<AkgecDigitalSchoolViewModel>({requireParentFragment()})

    private val videosRecyclerAdapter = VideosRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideosBinding.inflate(inflater, container, false)
        binding.videosRecyclerView.adapter = videosRecyclerAdapter
        binding.videosRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        akgecDigitalSchoolViewModel.getVideos()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        akgecDigitalSchoolViewModel.videosResponse.observe(viewLifecycleOwner){
            when(it){
                is NetworkResult.Success -> {
                    videosRecyclerAdapter.submitList(it.data!!.content)
                }
                is NetworkResult.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                is NetworkResult.Loading -> {

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
            _binding = null
    }

}