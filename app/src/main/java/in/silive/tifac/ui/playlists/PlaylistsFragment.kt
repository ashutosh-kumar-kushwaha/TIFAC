package `in`.silive.tifac.ui.playlists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import `in`.silive.tifac.adapters.PlaylistRecyclerAdapter
import `in`.silive.tifac.api.NetworkResult
import `in`.silive.tifac.databinding.FragmentPlaylistsBinding
import `in`.silive.tifac.ui.akgecDigitalSchool.AkgecDigitalSchoolViewModel

class PlaylistsFragment : Fragment() {

    private var _binding: FragmentPlaylistsBinding? = null
    private val binding: FragmentPlaylistsBinding get() = _binding!!

    private val akgecDigitalSchoolViewModel by viewModels<AkgecDigitalSchoolViewModel>({requireParentFragment()})

    private val playlistRecyclerAdapter = PlaylistRecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlaylistsBinding.inflate(inflater, container, false)

        binding.playlistRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.playlistRecyclerView.adapter = playlistRecyclerAdapter

        akgecDigitalSchoolViewModel.getPlaylists()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        akgecDigitalSchoolViewModel.playlistsResponse.observe(viewLifecycleOwner){
            when(it){
                is NetworkResult.Success -> {
                    playlistRecyclerAdapter.submitList(it.data?.content)
                }
                is NetworkResult.Error -> {

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