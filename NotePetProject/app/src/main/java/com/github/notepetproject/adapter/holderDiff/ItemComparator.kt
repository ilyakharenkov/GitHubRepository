package com.github.notepetproject.adapter.holderDiff

import androidx.recyclerview.widget.DiffUtil
import com.github.notepetproject.entities.NoteData

class ItemComparator: DiffUtil.ItemCallback<NoteData>() {

    override fun areItemsTheSame(oldItem: NoteData, newItem: NoteData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NoteData, newItem: NoteData): Boolean {
        return oldItem == newItem
    }

}