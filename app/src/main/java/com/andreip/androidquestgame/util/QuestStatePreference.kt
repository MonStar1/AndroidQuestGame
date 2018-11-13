package com.andreip.androidquestgame.util

import android.content.Context

private const val QUEST_STATE = "QUEST_STATE"
private const val QUEST_STARTED = "QUEST_STARTED"
private const val LEVEL_4_CODE = "LEVEL_4_CODE"

class QuestStatePreference(context: Context) {

    private val pref = PreferenceHelper.questStatePreferences(context)

    var questState: Int
        get() = pref.getInt(QUEST_STATE)
        set(value) = pref.putInt(QUEST_STATE, value)

    var questStarted: Boolean
        get() = pref.getBoolean(QUEST_STARTED)
        set(value) = pref.putBoolean(QUEST_STARTED, value)

    var level4Code: String
        get() = pref.getString(LEVEL_4_CODE)
        set(value) = pref.putString(LEVEL_4_CODE, value)
}