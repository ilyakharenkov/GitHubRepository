package com.github.architecturepetproject.data.repository

import com.github.architecturepetproject.data.storage.User
import com.github.architecturepetproject.data.storage.UserStorage
import com.github.architecturepetproject.domain.models.GetUserModels
import com.github.architecturepetproject.domain.models.SaveUserModels
import com.github.architecturepetproject.domain.repository.Repository

class RepositoryImp(private val userStorage: UserStorage) : Repository{

    override fun getUser(): GetUserModels {
        return mapToGet(user = userStorage.getUser())
    }

    override fun saveUser(saveUserModels: SaveUserModels): String{
        val user = mapToSave(saveUserModels = saveUserModels)
        return userStorage.saveUser(user = user)
    }

    private fun mapToGet(user: User) : GetUserModels{
        return GetUserModels(firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToSave(saveUserModels: SaveUserModels): User {
        return User(firstName = saveUserModels.firstName, lastName = saveUserModels.lastName)
    }

}