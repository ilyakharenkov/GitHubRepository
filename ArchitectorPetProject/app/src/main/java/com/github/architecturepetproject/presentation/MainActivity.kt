package com.github.architecturepetproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.architecturepetproject.data.repository.RepositoryImp
import com.github.architecturepetproject.databinding.ActivityMainBinding
import com.github.architecturepetproject.domain.models.SaveUserModels
import com.github.architecturepetproject.domain.usecase.GetUserNameUseCase
import com.github.architecturepetproject.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val userRepositoryImp = RepositoryImp()
    private val getUserNameUseCase = GetUserNameUseCase(repository = userRepositoryImp)
    private val saveUserNameUseCase = SaveUserNameUseCase(repository = userRepositoryImp)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClickMyButton()
    }

     private fun onClickMyButton(){

         binding.btnGet.setOnClickListener {
             val userName = getUserNameUseCase.execute()
             val user = "${userName.firstName} ${userName.lastName}"
             binding.tvResult.text = user
         }

         binding.btnSave.setOnClickListener {
             val first = binding.edTextViewFirst.text.toString()
             val last = binding.edTextViewLast.text.toString()
             val param = SaveUserModels(firstName = first, lastName = last)
             val result = saveUserNameUseCase.execute(saveUserModels = param)
             binding.tvResult.text = result
         }

     }
}