package com.example.mynotesapppetproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mynotesapppetproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ListenerNotes{ //ListenerNotes подключение интерфейса

    lateinit var binding: ActivityMainBinding
    private val notesAdapter = NotesAdapter(this)
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
              
        initRcView()

        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                notesAdapter.addNotes(it.data?.getSerializableExtra("notes") as DataNotes)
            }
        }
    }

    private fun initRcView(){
        binding.rcViewMainAct.layoutManager = GridLayoutManager(this@MainActivity, 5)
        binding.rcViewMainAct.adapter = notesAdapter
        binding.btnAdd.setOnClickListener {
            editLauncher?.launch(Intent(this, EditNotesActivity::class.java))
        }

    }

    override fun onClickNote(dataNotes: DataNotes) {
        startActivity(Intent(this,ContentNotesActivity::class.java).putExtra("item", dataNotes))
    }



}