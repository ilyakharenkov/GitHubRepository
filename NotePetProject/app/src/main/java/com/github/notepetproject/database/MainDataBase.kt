package com.github.notepetproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.notepetproject.daoMVVM.Dao
import com.github.notepetproject.entities.NoteData

@Database(entities = [NoteData::class], version = 1)
abstract class MainDataBase: RoomDatabase() {
    abstract fun noteDao(): Dao
    companion object {
        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun mainDataBase(context: Context):MainDataBase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    "note.db"
                ).build()
                instance
            }
        }
    }
}