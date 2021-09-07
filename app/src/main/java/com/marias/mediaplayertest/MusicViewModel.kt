package com.marias.mediaplayertest


import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation

class MusicViewModel : ViewModel() {

    var musicList = mutableListOf<Composition>()
    lateinit var activity:FragmentActivity
    var isHorizontal = true

    fun changeOrientation(): Boolean {
        val controller = Navigation.findNavController(activity, R.id.nav_host_fragment)
        if (isHorizontal){
            controller.navigate(R.id.action_singleElementFragment_to_listFragment)
            isHorizontal = !isHorizontal
        } else {
            controller.navigate(R.id.action_listFragment_to_singleElementFragment)
            isHorizontal = !isHorizontal
        }
        return true
    }
}