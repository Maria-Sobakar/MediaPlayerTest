package com.marias.mediaplayertest.ui.singleelement

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marias.mediaplayertest.R
import com.marias.mediaplayertest.data.Composition

class MusicSingleElementAdapter : RecyclerView.Adapter<MusicSingleElementAdapter.MusicSingleElementViewHolder>() {
    lateinit var musicList: List<Composition>
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MusicSingleElementViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.composition_item_horizontal, parent, false)
        return MusicSingleElementViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicSingleElementViewHolder, position: Int) {
        holder.bind(musicList[position])
    }

    override fun getItemCount() = musicList.size

    class MusicSingleElementViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val coverImageView = itemView.findViewById<ImageView>(R.id.coverImageViewHorizontal)
        val titleTextView = itemView.findViewById<TextView>(R.id.titleTextViewHorizontal)
        val authorTextView = itemView.findViewById<TextView>(R.id.authorTextViewHorizontal)

        fun bind(item: Composition) {
            coverImageView.setImageDrawable(item.cover)
            titleTextView.text = item.title
            authorTextView.text = item.author
        }
    }
}

