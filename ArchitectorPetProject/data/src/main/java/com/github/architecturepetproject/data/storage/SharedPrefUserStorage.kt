package com.github.architecturepetproject.data.storage

import android.content.Context
import com.github.architecturepetproject.data.repository.RepositoryConst

class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPref = context.getSharedPreferences(RepositoryConst.SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun getUser(): User {
        val first = sharedPref.getString(RepositoryConst.KEY_FIRST_NAME, RepositoryConst.DEFAULT) ?: RepositoryConst.DEFAULT
        val last = sharedPref.getString(RepositoryConst.KEY_LAST_NAME, RepositoryConst.DEFAULT) ?: RepositoryConst.DEFAULT
        return User(firstName = first, lastName = last)
    }

    override fun saveUser(user: User): String {
        sharedPref.edit().putString(RepositoryConst.KEY_FIRST_NAME, user.firstName).apply()
        sharedPref.edit().putString(RepositoryConst.KEY_LAST_NAME,user.lastName).apply()
        return "Saved successfully"
    }

}