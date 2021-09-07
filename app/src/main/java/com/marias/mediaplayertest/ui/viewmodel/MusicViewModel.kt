package com.marias.mediaplayertest.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marias.mediaplayertest.data.Composition
import kotlin.random.Random

class MusicViewModel : ViewModel() {

    var musicList = mutableListOf<Composition>()
    val isHorizontalLiveData = MutableLiveData<Boolean>()
    var isJustLaunch = true
    var itemNumberLiveData = MutableLiveData<Int>(Random.nextInt(0, 9))

    init {
        isHorizontalLiveData.value = true
    }

    fun changeOrientation(){
        isHorizontalLiveData.value = !isHorizontalLiveData.value!!
    }
}