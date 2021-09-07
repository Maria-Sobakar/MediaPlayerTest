package com.marias.mediaplayertest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicRecyclerViewAdapter : RecyclerView.Adapter<MusicViewHolder>() {
    lateinit var musicList: List<Composition>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.composition_item_vertical, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(musicList[position])
    }

    override fun getItemCount() = musicList.size
}

class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val coverImageView = itemView.findViewById<ImageView>(R.id.coverImageViewVertical)
    val titleTextView = itemView.findViewById<TextView>(R.id.titleTextViewVertical)
    val authorTextView = itemView.findViewById<TextView>(R.id.authorTextViewVertical)

    fun bind(item: Composition) {
        coverImageView.setImageDrawable(item.cover)
        titleTextView.text = item.title
        authorTextView.text = item.author
    }
}