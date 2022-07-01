package com.github.architecturepetproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.architecturepetproject.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClickMyButton()
        resultObserve()
    }

    private fun resultObserve(){
        vm.resultLive.observe(this) {
            binding.tvResult.text = it
        }
    }

     private fun onClickMyButton(){

         binding.btnGet.setOnClickListener {
             vm.load()
         }

         binding.btnSave.setOnClickListener {
             vm.save(binding = binding)
         }

     }
}