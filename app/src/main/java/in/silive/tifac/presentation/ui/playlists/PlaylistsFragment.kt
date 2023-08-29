package `in`.silive.tifac.presentation.ui.playlists

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
import `in`.silive.tifac.presentation.ui.adapters.PlaylistsAdapter
import `in`.silive.tifac.databinding.FragmentPlaylistsBinding
import `in`.silive.tifac.presentation.ui.adapters.PlaylistClickListener
import `in`.silive.tifac.presentation.ui.akgecDigitalSchool.AkgecDigitalSchoolViewModel
import kotlinx.coroutines.launch

class PlaylistsFragment : Fragment(), PlaylistClickListener {

    private var _binding: FragmentPlaylistsBinding? = null
    private val binding: FragmentPlaylistsBinding get() = _binding!!

    private val akgecDigitalSchoolViewModel by viewModels<AkgecDigitalSchoolViewModel>({requireParentFragment()})

    private val playlistsAdapter by lazy {
        PlaylistsAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlaylistsBinding.inflate(inflater, container, false)

        binding.playlistRecyclerView.adapter = playlistsAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                akgecDigitalSchoolViewModel.playlists.collect{
                    playlistsAdapter.submitList(it)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                akgecDigitalSchoolViewModel.arePlaylistsLoading.collect{

                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                akgecDigitalSchoolViewModel.playlistsErrorMessage.collect{
                    Snackbar.make(requireView(), it, Snackbar.LENGTH_SHORT).show()
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPlaylistClick(id: String) {

    }
}