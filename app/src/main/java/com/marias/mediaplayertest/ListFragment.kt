package com.marias.mediaplayertest

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.marias.mediaplayertest.databinding.FragmentListBinding

class ListFragment:Fragment() {
    private val viewModel by activityViewModels<MusicViewModel>()
    private lateinit var binding:FragmentListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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
        val adapter = MusicRecyclerViewAdapter()
        adapter.musicList = viewModel.musicList
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)

        val switchOrientation = menu.findItem(R.id.switchButton)
        if (viewModel.isHorizontal) {
            switchOrientation?.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_list)
        } else {
            switchOrientation?.icon = ContextCompat.getDrawable(requireContext(), R.drawable.ic_view_carousel)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return viewModel.changeOrientation()
    }
}