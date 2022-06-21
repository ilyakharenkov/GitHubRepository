package com.github.notepetproject.daoMVVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.notepetproject.database.MainDataBase

class MainViewModelFactory(private val dataBase: MainDataBase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress ("UNCHECKED_CAST")
        return MainViewModel(dataBase) as T
        }
        throw IllegalAccessException("Unknown ViewModelClass")
    }
}