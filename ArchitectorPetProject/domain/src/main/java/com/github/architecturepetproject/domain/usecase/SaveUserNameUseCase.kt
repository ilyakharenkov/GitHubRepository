package com.github.architecturepetproject.domain.usecase

import com.github.architecturepetproject.domain.models.SaveUserModels
import com.github.architecturepetproject.domain.repository.Repository

class SaveUserNameUseCase(private val repository: Repository){

    fun execute(saveUserModels: SaveUserModels): String{

        val oldName = repository.getUser()

        if (oldName.firstName == saveUserModels.firstName && oldName.lastName == saveUserModels.lastName)
            return "overlap"

        return if(saveUserModels.firstName.isEmpty() && saveUserModels.lastName.isEmpty()) "Empty"
        else
            repository.saveUser(saveUserModels = saveUserModels)
    }
}