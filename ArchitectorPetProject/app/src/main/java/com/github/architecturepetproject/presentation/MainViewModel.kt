package com.github.architecturepetproject.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.architecturepetproject.databinding.ActivityMainBinding
import com.github.architecturepetproject.domain.models.SaveUserModels
import com.github.architecturepetproject.domain.usecase.GetUserNameUseCase
import com.github.architecturepetproject.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
    ) : ViewModel() {

    private val liveData = MutableLiveData<String>()
    val resultLive: LiveData<String> = liveData

    fun load() {
        val userName = getUserNameUseCase.execute()
        liveData.value = "${userName.firstName} ${userName.lastName}"
    }

    fun save(binding: ActivityMainBinding) {
        val first = binding.edTextViewFirst.text.toString()
        val last = binding.edTextViewLast.text.toString()
        val param = SaveUserModels(firstName = first, lastName = last)
        liveData.value = saveUserNameUseCase.execute(saveUserModels = param)
    }
}