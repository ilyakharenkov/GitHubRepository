package com.github.notepetproject.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.github.notepetproject.R
import com.github.notepetproject.databinding.ActivityNewNoteBinding
import com.github.notepetproject.ab.ActionBarSettingsMain
import com.github.notepetproject.entities.NoteData
import com.github.notepetproject.intent.KeyConst
import com.github.notepetproject.intent.ResultNewNoteActivity
import com.github.notepetproject.utility.CurrentTime

class NewNoteActivity: AppCompatActivity(), CurrentTime{

    lateinit var binding: ActivityNewNoteBinding
    private val actionBarSettingsMain = ActionBarSettingsMain()
    private val resultNewNoteActivity = ResultNewNoteActivity(this)
    var noteData : NoteData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBarSettingsMain.actionBarSettings(this)
        getNote()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.new_note_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.id_save -> resultNewNoteActivity.setMyResult(this)
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getNote(){ //Получение заметки для создания или редактирования
        val sNote = intent.getSerializableExtra(KeyConst.NOTE_KEY)
        if (sNote != null){
            noteData = sNote as NoteData
            fillNote()
        }
    }
    private fun fillNote(){
        binding.edTitle.setText(noteData?.noteTitle)
        binding.edDescription.setText(noteData?.noteDesc)
    }

}