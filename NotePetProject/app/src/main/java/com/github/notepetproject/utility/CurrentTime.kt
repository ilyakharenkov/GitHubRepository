package com.github.notepetproject.utility

import java.text.SimpleDateFormat
import java.util.*

interface CurrentTime {
    fun timeNote(): String {
        val formatter = SimpleDateFormat("HH:mm dd/MM/yyyy", Locale.getDefault())
        return formatter.format(Calendar.getInstance().time)
    }
}