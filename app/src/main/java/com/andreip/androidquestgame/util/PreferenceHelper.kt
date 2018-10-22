package com.andreip.androidquestgame.util

import android.content.Context

class PreferenceHelper private constructor(val context: Context, name: String) {

    private val sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)!!

    companion object {
        fun timerPreferences(context: Context): PreferenceHelper {
            return PreferenceHelper(context, "TIMER_PREFERENCES")
        }
    }

    fun putString(key: String, value: String) = sharedPreferences.edit().putString(key, value).apply()

    fun getString(key: String) = sharedPreferences.getString(key, null)

    fun putLong(key: String, value: Long) = sharedPreferences.edit().putLong(key, value).apply()

    fun getLong(key: String) = sharedPreferences.getLong(key, 0)
}