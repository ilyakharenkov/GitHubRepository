package com.github.notepetproject.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "note_entities")
data class NoteData(

    @PrimaryKey (autoGenerate = true)
    val id: Int?,

    @ColumnInfo(name = "note_title")
    val noteTitle: String,

    @ColumnInfo(name = "note_description")
    val noteDesc: String,

    @ColumnInfo(name = "note_time")
    val noteTime: String

): Serializable


