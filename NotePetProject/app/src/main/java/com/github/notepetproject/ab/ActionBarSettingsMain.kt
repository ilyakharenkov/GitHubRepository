package com.github.notepetproject.ab

import androidx.appcompat.app.AppCompatActivity

class ActionBarSettingsMain{
    fun actionBarSettings(activity: AppCompatActivity){
        val ab = activity.supportActionBar
        ab?.setDisplayHomeAsUpEnabled(true)
    }
}