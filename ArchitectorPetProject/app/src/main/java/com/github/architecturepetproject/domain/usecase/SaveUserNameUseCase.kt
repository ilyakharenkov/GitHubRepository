package com.github.architecturepetproject.domain.usecase

import com.github.architecturepetproject.domain.models.SaveUserModels
import com.github.architecturepetproject.domain.repository.Repository

class SaveUserNameUseCase(private val repository: Repository){

    fun execute(saveUserModels: SaveUserModels): String{
           return repository.saveUser(saveUserModels = saveUserModels)
    }
}