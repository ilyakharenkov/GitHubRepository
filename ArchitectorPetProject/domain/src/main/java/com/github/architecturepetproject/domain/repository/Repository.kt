package com.github.architecturepetproject.domain.repository

import com.github.architecturepetproject.domain.models.GetUserModels
import com.github.architecturepetproject.domain.models.SaveUserModels

interface Repository {

    fun getUser() : GetUserModels
    fun saveUser(saveUserModels: SaveUserModels): String

}