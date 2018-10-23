package com.andreip.androidquestgame

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import androidx.navigation.findNavController
import com.andreip.androidquestgame.state.QuestState
import java.lang.IllegalStateException
import android.view.WindowManager
import android.os.Build


class QuestActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = Color.BLACK
        }

        questStatePref.questState = 0 //TORO remove later

        restoreQuestState()
    }

    private fun restoreQuestState() {
        val action = when (questStatePref.questState) {
            QuestState.INTRO.ordinal -> R.id.introFragment
            QuestState.LEVEL_1.ordinal -> R.id.level1Fragment
            QuestState.LEVEL_2.ordinal -> R.id.level2Fragment
            else -> throw IllegalStateException("Level doesn't exists")
        }

        findNavController(R.id.nav_host_fragment).navigate(action)
    }
}