package com.github.notepetproject.daoMVVM


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.github.notepetproject.database.MainDataBase
import com.github.notepetproject.entities.NoteData
import kotlinx.coroutines.launch

class MainViewModel(dataBase: MainDataBase) : ViewModel() {

    private val dao = dataBase.noteDao()
    val allNotes : LiveData<List<NoteData>> = dao.allNotes().asLiveData()

    fun insertNote(noteData: NoteData) = viewModelScope.launch{
        dao.insertNote(noteData)
    }

    fun updateNote(noteData: NoteData) = viewModelScope.launch{
        dao.updateNote(noteData)
    }

    fun deleteNote(id: Int) = viewModelScope.launch{
        dao.deleteNotes(id)
    }
}