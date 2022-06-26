package com.github.architecturepetproject.data.repository

import android.content.Context
import com.github.architecturepetproject.domain.models.GetUserModels
import com.github.architecturepetproject.domain.models.SaveUserModels
import com.github.architecturepetproject.domain.repository.Repository


class RepositoryImp(context: Context) : Repository{

    private val shadePref = context.getSharedPreferences(RepositoryConst.KEY_NAME, )

    override fun getUser() : GetUserModels {
        return GetUserModels(firstName = "first", lastName = "last")
    }

    override fun saveUser(saveUserModels: SaveUserModels): String{
        return if (saveUserModels.firstName.isEmpty() && saveUserModels.lastName.isEmpty())
            "Empty"
        else
            "Name:${saveUserModels.firstName} Family:${saveUserModels.lastName}"

    }

}