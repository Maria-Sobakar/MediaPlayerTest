package com.marias.mediaplayertest.ui.singleelement

import android.os.Bundle
import android.view.*
import androidx.activity.addCallback
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.marias.mediaplayertest.R
import com.marias.mediaplayertest.databinding.FragmentSingleElementBinding
import com.marias.mediaplayertest.ui.viewmodel.MusicViewModel

class SingleElementFragment : Fragment() {
    private val viewModel by activityViewModels<MusicViewModel>()
    private lateinit var binding: FragmentSingleElementBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            finishAffinity(requireActivity())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingleElementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MusicSingleElementAdapter().apply {
            musicList = viewModel.musicList
        }
        binding.viewPager.apply {
            orientation = (ViewPager2.ORIENTATION_HORIZONTAL);
            this.adapter = adapter
            offscreenPageLimit = 3
        }
        viewModel.isHorizontalLiveData.observe(viewLifecycleOwner) { isHorizontal ->
            val controller = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
            if (!isHorizontal) {
                controller.navigate(R.id.action_singleElementFragment_to_listFragment)
            }
        }
        viewModel.itemNumberLiveData.observe(viewLifecycleOwner) {
            binding.viewPager.apply {
                setCurrentItem(it, false)
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onResume() {
        super.onResume()

        if (viewModel.isJustLaunch) {
            viewModel.isJustLaunch = false
            binding.viewPager.apply {
            }
        }
    }

    override fun onDestroyView() {
        viewModel.itemNumberLiveData.value = binding.viewPager.currentItem
        super.onDestroyView()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)

        val switchOrientation = menu.findItem(R.id.switchButton)
        switchOrientation?.icon =
            ContextCompat.getDrawable(requireContext(), R.drawable.ic_list)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.changeOrientation()
        return true
    }
}