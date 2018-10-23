package com.andreip.androidquestgame.level1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.questStatePref
import com.andreip.androidquestgame.state.QuestState
import com.andreip.androidquestgame.timer.TimerController
import kotlinx.android.synthetic.main.fragment_level_1.*

private val CODES = arrayOf("111")

class Level1Fragment : Fragment() {

    val timer = TimerController("tag")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        questStatePref.questState = QuestState.LEVEL_1.ordinal
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_level_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonNext.setOnClickListener {
            findNavController().navigate(R.id.action_level1Fragment_to_level2Fragment)
        }

//        accept.setOnClickListener {
//            if (CODES.contains(code.text.toString())) {
//                buttonNext.show()
//                textInputLayout.isErrorEnabled = false
//            } else {
//                buttonNext.hide()
//                textInputLayout.error = "Введите правильный код"
//                textInputLayout.isErrorEnabled = true
//            }
//        }

        timer.clear()//TODO remove later

        if (!timer.isTimerStarted()) {
            timer.startNow(60)
        }

        timer.subscribe({
            //            counter.text = timer.convertMillisToTime(it)

//            Log.d("logoff", "Counter: ${counter.text}")
        }, {
            //            counter.text = "Time is over"
        })
    }

    override fun onDestroyView() {
        timer.unsubscribe()

        super.onDestroyView()
    }
}