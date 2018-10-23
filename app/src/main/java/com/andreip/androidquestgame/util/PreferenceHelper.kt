package com.andreip.androidquestgame.util

import android.content.Context

class PreferenceHelper private constructor(val context: Context, name: String) {

    private val sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)!!

    companion object {
        fun timerPreferences(context: Context): PreferenceHelper {
            return PreferenceHelper(context, "TIMER_PREFERENCES")
        }

        fun questStatePreferences(context: Context): PreferenceHelper {
            return PreferenceHelper(context, "QUEST_STATE_PREFERENCES")
        }
    }

    fun putString(key: String, value: String) = sharedPreferences.edit().putString(key, value).apply()

    fun getString(key: String) = sharedPreferences.getString(key, null)

    fun putLong(key: String, value: Long) = sharedPreferences.edit().putLong(key, value).apply()

    fun getLong(key: String) = sharedPreferences.getLong(key, 0)

    fun putInt(key: String, value: Int) = sharedPreferences.edit().putInt(key, value).apply()

    fun getInt(key: String) = sharedPreferences.getInt(key, 0)

    fun putBoolean(key: String, value: Boolean) = sharedPreferences.edit().putBoolean(key, value).apply()

    fun getBoolean(key: String) = sharedPreferences.getBoolean(key, false)
}