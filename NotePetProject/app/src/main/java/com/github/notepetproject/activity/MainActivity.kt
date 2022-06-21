package com.github.notepetproject.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.notepetproject.R
import com.github.notepetproject.databinding.ActivityMainBinding
import com.github.notepetproject.fragment.FragmentManager
import com.github.notepetproject.intent.KeyConst

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var fragmentManager = FragmentManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottomNavigation()
        fragmentManager.setFragment(this, KeyConst.newInstance())
    }

    private fun bottomNavigation(){
        binding.btnNavView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.note -> {
                    fragmentManager.setFragment( this, KeyConst.newInstance())
                }
                R.id.note_new -> {
                   fragmentManager.baseFragment?.onClickNew()
                }
            }
            true
        }
    }

}