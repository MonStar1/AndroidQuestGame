package com.andreip.androidquestgame.util

import android.content.Context

private const val START_TIME = "START_TIME"
private const val TIMER_LIMIT_IN_SECONDS = "TIMER_LIMIT_IN_SECONDS"

class TimerPreference(context: Context) {

    private val pref = PreferenceHelper.timerPreferences(context)

    fun setTimerLimitInMillis(tag: String, time: Long) {
        pref.putLong(TIMER_LIMIT_IN_SECONDS + tag, time)
    }

    fun getTimerLimitInMillis(tag: String) = pref.getLong(TIMER_LIMIT_IN_SECONDS + tag)

    fun setStartTime(tag: String, time: Long) {
        pref.putLong(START_TIME + tag, time)
    }

    fun getStartTime(tag: String) = pref.getLong(START_TIME + tag)
}