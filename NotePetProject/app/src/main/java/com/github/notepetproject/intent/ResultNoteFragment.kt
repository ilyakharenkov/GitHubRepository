package com.github.notepetproject.intent

import android.app.Activity
import androidx.activity.result.contract.ActivityResultContracts
import com.github.notepetproject.entities.NoteData
import com.github.notepetproject.fragment.NoteFragment

class ResultNoteFragment {

    fun getMyResult(noteFragment: NoteFragment){//Получение данных
        noteFragment.editLauncher = noteFragment.registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == Activity.RESULT_OK){
                val editState = it.data?.getStringExtra(KeyConst.NOTE_KEY_STATE)
                if(editState == "update"){
                    noteFragment.mainViewModel.updateNote(it.data?.getSerializableExtra(KeyConst.NOTE_KEY) as NoteData)
                } else {
                noteFragment.mainViewModel.insertNote(it.data?.getSerializableExtra(KeyConst.NOTE_KEY) as NoteData)
                }
            }
        }
    }
}

