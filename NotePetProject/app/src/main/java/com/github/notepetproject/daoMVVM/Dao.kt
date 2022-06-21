package com.github.notepetproject.daoMVVM

import androidx.room.*
import androidx.room.Dao
import com.github.notepetproject.entities.NoteData
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Query("SELECT * FROM note_entities")
    fun allNotes(): Flow<List<NoteData>>

    @Query("DELETE FROM note_entities WHERE id IS :id")
    suspend fun deleteNotes(id: Int)

    @Insert
    suspend fun insertNote(noteData: NoteData)

    @Update
    suspend fun updateNote(noteData: NoteData)

}