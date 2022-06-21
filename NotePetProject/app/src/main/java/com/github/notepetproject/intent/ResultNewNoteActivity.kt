package com.github.notepetproject.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.github.notepetproject.activity.NewNoteActivity
import com.github.notepetproject.entities.NoteData
import com.github.notepetproject.utility.CurrentTime

class ResultNewNoteActivity(private val newNoteActivity: NewNoteActivity): CurrentTime{

    fun setMyResult(newNoteActivity: NewNoteActivity){
        var editState = "new"
        val tempNote: NoteData? = if (newNoteActivity.noteData == null){
            createNewNote()
        }else {
            editState = "update"
            updateNote()
        }
        val i = Intent()
            .putExtra(KeyConst.NOTE_KEY, tempNote)
            .putExtra(KeyConst.NOTE_KEY_STATE, editState)
        newNoteActivity.setResult(AppCompatActivity.RESULT_OK, i)
        newNoteActivity.finish()
    }

    private fun createNewNote(): NoteData {
        return NoteData(
            null,
            newNoteActivity.binding.edTitle.text.toString(),
            newNoteActivity.binding.edDescription.text.toString(),
            timeNote()
        )
    }

    private fun updateNote(): NoteData?{
        return newNoteActivity.noteData?.copy(
            noteTitle = newNoteActivity.binding.edTitle.text.toString(),
            noteDesc = newNoteActivity.binding.edDescription.text.toString()
        )
    }
}
