package `in`.silive.tifac.presentation.ui.videos

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import `in`.silive.tifac.presentation.ui.adapters.VideosRecyclerAdapter
import `in`.silive.tifac.common.NetworkResult
import `in`.silive.tifac.databinding.FragmentVideosBinding
import `in`.silive.tifac.interfaces.ItemClickListener
import `in`.silive.tifac.presentation.ui.akgecDigitalSchool.AkgecDigitalSchoolViewModel
import `in`.silive.tifac.presentation.ui.videoPlayer.VideoPlayerActivity

@AndroidEntryPoint
class VideosFragment : Fragment() {

    private var _binding : FragmentVideosBinding? = null
    private val binding: FragmentVideosBinding get() = _binding!!

    private val akgecDigitalSchoolViewModel by viewModels<AkgecDigitalSchoolViewModel>({requireParentFragment()})

    private lateinit var videosRecyclerAdapter: VideosRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideosBinding.inflate(inflater, container, false)


        val itemClickListener = object : ItemClickListener{
            override fun onItemClick(id: String) {
                val intent = Intent(requireContext(), VideoPlayerActivity::class.java)
                intent.putExtra("videoId", id)
                startActivity(intent)
            }
        }

        videosRecyclerAdapter = VideosRecyclerAdapter(itemClickListener)

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