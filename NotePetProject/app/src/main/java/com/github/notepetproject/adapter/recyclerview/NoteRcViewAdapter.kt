package com.github.notepetproject.adapter.recyclerview



import androidx.recyclerview.widget.GridLayoutManager
import com.github.notepetproject.adapter.NoteAdapter
import com.github.notepetproject.databinding.FragmentNoteBinding
import com.github.notepetproject.fragment.NoteFragment

class NoteRcViewAdapter {

    lateinit var noteAdapter: NoteAdapter

    fun initRcViewNoteAdapter(binding: FragmentNoteBinding, noteFragment: NoteFragment){
        binding.rcViewNote.layoutManager = GridLayoutManager(noteFragment.activity,3)
        noteAdapter = NoteAdapter(noteFragment)
        binding.rcViewNote.adapter = noteAdapter
    }
}