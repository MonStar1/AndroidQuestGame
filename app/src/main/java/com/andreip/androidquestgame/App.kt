package com.andreip.androidquestgame

import android.app.Application
import com.andreip.androidquestgame.util.QuestStatePreference
import com.andreip.androidquestgame.util.TimerPreference

lateinit var timerPref: TimerPreference
lateinit var questStatePref: QuestStatePreference

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        timerPref = TimerPreference(this)
        questStatePref = QuestStatePreference(this)
    }
}