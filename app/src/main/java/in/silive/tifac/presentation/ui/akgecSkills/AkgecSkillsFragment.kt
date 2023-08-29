package `in`.silive.tifac.presentation.ui.akgecSkills

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import `in`.silive.tifac.databinding.FragmentAkgecSkillsBinding

class AkgecSkillsFragment : Fragment() {

    private var _binding: FragmentAkgecSkillsBinding? = null
    private val binding: FragmentAkgecSkillsBinding get() = _binding!!

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAkgecSkillsBinding.inflate(inflater, container, false)

        binding.webView.loadUrl("https://akgecskills.in/")
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.webViewClient = WebViewClient()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}