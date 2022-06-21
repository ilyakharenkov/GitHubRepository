package com.github.notepetproject.adapter


import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.github.notepetproject.adapter.holderDiff.ItemComparator
import com.github.notepetproject.adapter.holderDiff.NoteItemHolder
import com.github.notepetproject.entities.NoteData
import com.github.notepetproject.utility.NoteUtil



class NoteAdapter(private val noteUtil: NoteUtil): ListAdapter<NoteData, NoteItemHolder>(ItemComparator()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemHolder {
        return NoteItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: NoteItemHolder, position: Int) {
        holder.setData(getItem(position), noteUtil)
    }


}






