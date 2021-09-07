package com.marias.mediaplayertest.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.marias.mediaplayertest.R
import com.marias.mediaplayertest.data.Composition
import com.marias.mediaplayertest.ui.viewmodel.MusicViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MusicViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (viewModel.musicList.isEmpty()) {
            addCompositions()
        }
    }

    private fun addCompositions() {
        val composition1 = Composition(
            ContextCompat.getDrawable(this, R.drawable.from_time)!!,
            "From Time (feat. Jhené Aiko).mp3",
            "Drake"
        )
        val composition2 = Composition(
            ContextCompat.getDrawable(this, R.drawable.nda)!!,
            "NDA.mp3",
            "Billie Eilish"
        )
        val composition3 = Composition(
            ContextCompat.getDrawable(this, R.drawable.know_yourself)!!,
            "Know Yourself.mp3",
            "Drake"
        )
        val composition4 = Composition(
            ContextCompat.getDrawable(this, R.drawable.need_to_know)!!,
            "Need to Know.mp3",
            "Doja Cat"
        )
        val composition5 = Composition(
            ContextCompat.getDrawable(this, R.drawable.needed_me)!!,
            "Needed Me.mp3",
            "Rihanna"
        )
        val composition6 = Composition(
            ContextCompat.getDrawable(this, R.drawable.she_knows)!!,
            "She Knows (feat. Amber Coffman and Cults).mp3",
            "J.Cole"
        )
        val composition7 = Composition(
            ContextCompat.getDrawable(this, R.drawable.laugh_now_cry_later)!!,
            "Laugh Now Cry Later (feat. Lil Durk).mp3",
            "Drake"
        )
        val composition8 = Composition(
            ContextCompat.getDrawable(this, R.drawable.neighbors)!!,
            "Neighbors.mp3",
            "J.Cole"
        )
        val composition9 = Composition(
            ContextCompat.getDrawable(this, R.drawable.no_role_modelz)!!,
            "No Role Modelz.mp3",
            "J.Cole"
        )
        val composition10 = Composition(
            ContextCompat.getDrawable(this, R.drawable.work_out)!!,
            "Work Out.mp3",
            "J.Cole"
        )
        viewModel.musicList.addAll(
            listOf(
                composition1,
                composition2,
                composition3,
                composition4,
                composition5,
                composition6,
                composition7,
                composition8,
                composition9,
                composition10
            )
        )
    }
}