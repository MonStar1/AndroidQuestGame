package com.andreip.androidquestgame.util

import android.content.Context

private const val QUEST_STATE = "QUEST_STATE"
private const val QUEST_STARTED = "QUEST_STARTED"

class QuestStatePreference(context: Context) {

    private val pref = PreferenceHelper.questStatePreferences(context)

    var questState: Int
        get() = pref.getInt(QUEST_STATE)
        set(value) = pref.putInt(QUEST_STATE, value)

    var questStarted: Boolean
        get() = pref.getBoolean(QUEST_STARTED)
        set(value) = pref.putBoolean(QUEST_STARTED, value)
}