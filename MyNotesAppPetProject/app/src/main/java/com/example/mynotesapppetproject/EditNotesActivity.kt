package com.example.mynotesapppetproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mynotesapppetproject.databinding.ActivityEditNotesBinding

class EditNotesActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnDone()
    }

    private fun btnDone(){
        binding.btnDone.setOnClickListener {
            val notes = DataNotes(R.drawable.notes_image, binding.edTitle.text.toString(),binding.edDescription.text.toString())
                val edIntent = Intent().putExtra("notes", notes)
                setResult(RESULT_OK, edIntent)
                finish()
        }
    }


}