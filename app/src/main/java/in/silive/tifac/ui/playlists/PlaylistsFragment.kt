package `in`.silive.tifac.ui.playlists

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import `in`.silive.tifac.R
import `in`.silive.tifac.databinding.FragmentPlaylistsBinding
import `in`.silive.tifac.ui.akgecDigitalSchool.AkgecDigitalSchoolViewModel

class PlaylistsFragment : Fragment() {

    private var _binding: FragmentPlaylistsBinding? = null
    private val binding: FragmentPlaylistsBinding get() = _binding!!

    private val akgecDigitalSchoolViewModel by viewModels<AkgecDigitalSchoolViewModel>({requireParentFragment()})

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlaylistsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        akgecDigitalSchoolViewModel.getPlaylists()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}