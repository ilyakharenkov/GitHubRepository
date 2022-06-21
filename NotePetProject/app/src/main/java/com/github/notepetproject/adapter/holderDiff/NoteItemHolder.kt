package com.github.notepetproject.adapter.holderDiff

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.notepetproject.R
import com.github.notepetproject.databinding.NoteItemBinding
import com.github.notepetproject.entities.NoteData
import com.github.notepetproject.utility.NoteUtil

class NoteItemHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = NoteItemBinding.bind(view)

    fun setData(noteData: NoteData, noteUtil: NoteUtil){
        binding.tvTitle.text = noteData.noteTitle
        binding.tvDescription.text = noteData.noteDesc
        binding.tvTime.text = noteData.noteTime
        itemView.setOnClickListener {
            noteUtil.onClickNote(noteData)
        }
        binding.btnDelete.setOnClickListener {
            noteUtil.deleteNote(noteData.id!!)
        }
    }

    companion object {
        fun create(parent: ViewGroup): NoteItemHolder {
            return NoteItemHolder(LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.note_item, parent, false))
        }
    }


}