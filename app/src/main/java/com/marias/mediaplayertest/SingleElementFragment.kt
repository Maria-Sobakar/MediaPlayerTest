package com.marias.mediaplayertest

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.marias.mediaplayertest.databinding.CompositionItemHorizontalBinding
import com.marias.mediaplayertest.databinding.FragmentSingleElementBinding

class SingleElementFragment : Fragment() {
    private val viewModel by activityViewModels<MusicViewModel>()
    private lateinit var binding: FragmentSingleElementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingleElementBinding.inflate(inflater, container, false)
        viewModel.activity = requireActivity()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MusicSingleElementAdapter()
        adapter.musicList = viewModel.musicList
        binding.viewPager.apply {
            orientation = (ViewPager2.ORIENTATION_HORIZONTAL);
            this.adapter = adapter
            offscreenPageLimit = 3
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)

        val switchOrientation = menu.findItem(R.id.switchButton)
        if (viewModel.isHorizontal) {
            switchOrientation?.icon =
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_list)
        } else {
            switchOrientation?.icon =
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_view_carousel)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return viewModel.changeOrientation()
    }
}