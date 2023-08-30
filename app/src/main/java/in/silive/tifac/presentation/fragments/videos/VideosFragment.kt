package `in`.silive.tifac.presentation.fragments.videos

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import `in`.silive.tifac.presentation.adapters.VideosAdapter
import `in`.silive.tifac.databinding.FragmentVideosBinding
import `in`.silive.tifac.presentation.adapters.VideoClickListener
import `in`.silive.tifac.presentation.viewModels.AkgecDigitalSchoolViewModel
import `in`.silive.tifac.presentation.activities.videoPlayer.VideoPlayerActivity
import kotlinx.coroutines.launch

@AndroidEntryPoint
class VideosFragment : Fragment(), VideoClickListener {

    private var _binding : FragmentVideosBinding? = null
    private val binding: FragmentVideosBinding get() = _binding!!

    private val akgecDigitalSchoolViewModel by viewModels<AkgecDigitalSchoolViewModel>({requireParentFragment()})

    private val videosAdapter by lazy {
        VideosAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideosBinding.inflate(inflater, container, false)

        binding.videosRecyclerView.adapter = videosAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                akgecDigitalSchoolViewModel.videos.collect{
                    videosAdapter.submitList(it)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                akgecDigitalSchoolViewModel.areVideosLoading.collect{

                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                akgecDigitalSchoolViewModel.videosErrorMessage.collect{
                    Snackbar.make(requireView(), it, Snackbar.LENGTH_SHORT).show()
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
            _binding = null
    }

    override fun onVideoClick(id: String) {
        val intent = Intent(requireContext(), VideoPlayerActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

}