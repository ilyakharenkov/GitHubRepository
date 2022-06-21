package com.github.notepetproject.database

import android.app.Application

class MainApp: Application() {
    val dataBase by lazy { MainDataBase.mainDataBase(this) }
}