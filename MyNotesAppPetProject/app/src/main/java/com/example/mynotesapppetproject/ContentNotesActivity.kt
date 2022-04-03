package com.example.mynotesapppetproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mynotesapppetproject.databinding.ActivityContentNotesBinding

class ContentNotesActivity : AppCompatActivity() {

    lateinit var binding: ActivityContentNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val notesItem = intent.getSerializableExtra("item") as DataNotes
        binding.tvContentTitle.text = notesItem.fileName
        binding.tvContentDesc.text = notesItem.description
    }

}