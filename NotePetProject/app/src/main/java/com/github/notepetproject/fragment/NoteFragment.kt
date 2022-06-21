package com.github.notepetproject.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import com.github.notepetproject.activity.NewNoteActivity
import com.github.notepetproject.adapter.recyclerview.NoteRcViewAdapter
import com.github.notepetproject.databinding.FragmentNoteBinding
import com.github.notepetproject.entities.NoteData
import com.github.notepetproject.intent.KeyConst
import com.github.notepetproject.intent.ResultNoteFragment
import com.github.notepetproject.utility.NoteUtil

class NoteFragment: BaseFragment() , NoteUtil{

    private lateinit var binding: FragmentNoteBinding
    private val noteRcViewAdapter = NoteRcViewAdapter()
    private val resultNoteFragment = ResultNoteFragment()
    lateinit var editLauncher: ActivityResultLauncher<Intent>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        noteRcViewAdapter.initRcViewNoteAdapter(binding, this)
        observeNote()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultNoteFragment.getMyResult(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onClickNew() {
        editLauncher.launch(Intent(activity, NewNoteActivity::class.java))
    }

    private fun observeNote(){
        mainViewModel.allNotes.observe(viewLifecycleOwner){
            noteRcViewAdapter.noteAdapter.submitList(it)
        }
    }

    override fun deleteNote(id: Int) {
        mainViewModel.deleteNote(id)
    }

    override fun onClickNote(noteData: NoteData) {
        val intent = Intent(activity, NewNoteActivity::class.java)
           .putExtra(KeyConst.NOTE_KEY, noteData)
            editLauncher.launch(intent)
    }
}