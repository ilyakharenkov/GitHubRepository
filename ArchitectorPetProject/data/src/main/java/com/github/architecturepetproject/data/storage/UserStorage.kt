package com.github.architecturepetproject.data.storage


interface UserStorage  {

    fun getUser() : User

    fun saveUser(user: User) : String


}