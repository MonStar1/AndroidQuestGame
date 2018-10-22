package com.andreip.androidquestgame

import android.app.Application
import com.andreip.androidquestgame.util.TimerPreference

lateinit var timerPref: TimerPreference

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        timerPref = TimerPreference(this)
    }
}