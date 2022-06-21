package com.github.notepetproject.utility

import com.github.notepetproject.entities.NoteData

interface NoteUtil {
    fun deleteNote(id: Int)
    fun onClickNote(noteData: NoteData){
    }
}