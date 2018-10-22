package com.andreip.androidquestgame.util

import android.content.Context

private const val START_TIME = "START_TIME"
private const val TIMER_LIMIT_IN_SECONDS = "TIMER_LIMIT_IN_SECONDS"

class TimerPreference(context: Context) {

    private val pref = PreferenceHelper.timerPreferences(context)

    var startTime: Long
        get() = pref.getLong(START_TIME)
        set(value) = pref.putLong(START_TIME, value)

    var timerLimitInMillis: Long
        get() = pref.getLong(TIMER_LIMIT_IN_SECONDS)
        set(value) = pref.putLong(TIMER_LIMIT_IN_SECONDS, value)
}