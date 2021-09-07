package com.marias.mediaplayertest.ui.listitems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marias.mediaplayertest.R
import com.marias.mediaplayertest.data.Composition

class MusicListAdapter : RecyclerView.Adapter<MusicListAdapter.MusicListViewHolder>() {
    lateinit var musicList: List<Composition>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.composition_item_vertical, parent, false)
        return MusicListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicListViewHolder, position: Int) {
        holder.bind(musicList[position])
    }

    override fun getItemCount() = musicList.size

    class MusicListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val coverImageView = itemView.findViewById<ImageView>(R.id.coverImageViewVertical)
        private val titleTextView = itemView.findViewById<TextView>(R.id.titleTextViewVertical)
        private val authorTextView = itemView.findViewById<TextView>(R.id.authorTextViewVertical)

        fun bind(item: Composition) {
            coverImageView.setImageDrawable(item.cover)
            titleTextView.text = item.title
            authorTextView.text = item.author
        }
    }
}

