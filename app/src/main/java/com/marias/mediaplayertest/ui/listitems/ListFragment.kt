package com.marias.mediaplayertest.ui.listitems

import android.os.Bundle
import android.view.*
import androidx.activity.addCallback
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.marias.mediaplayertest.R
import com.marias.mediaplayertest.databinding.FragmentListBinding
import com.marias.mediaplayertest.ui.viewmodel.MusicViewModel

class ListFragment : Fragment() {
    private val viewModel by activityViewModels<MusicViewModel>()
    private lateinit var binding: FragmentListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            ActivityCompat.finishAffinity(requireActivity())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MusicListAdapter().apply {
            musicList = viewModel.musicList
        }
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }
        viewModel.isHorizontalLiveData.observe(viewLifecycleOwner) { isHorizontal ->
            val controller = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
            if (isHorizontal) {
                controller.navigate(R.id.action_listFragment_to_singleElementFragment)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        val switchOrientation = menu.findItem(R.id.switchButton)
        switchOrientation?.icon =
            ContextCompat.getDrawable(requireContext(), R.drawable.ic_view_carousel)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.changeOrientation()
        return true
    }
}