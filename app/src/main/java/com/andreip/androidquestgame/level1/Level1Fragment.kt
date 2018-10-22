package com.andreip.androidquestgame.level1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.timer.TimerController
import kotlinx.android.synthetic.main.fragment_level_1.*
import java.text.SimpleDateFormat
import java.util.*

class Level1Fragment : Fragment() {

    val timer = TimerController("tag")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_level_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_next.setOnClickListener {
            findNavController().navigate(R.id.level2Fragment)
        }

        timer.clear()

        if (!timer.isTimerStarted()) {
            timer.startNow(60)
        }

        timer.subscribe({
            val calendar = Calendar.getInstance().apply {
                timeInMillis = it
                add(Calendar.HOUR, -3)
            }

            counter.text = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(calendar.time)

            Log.d("logoff", "Counter: ${counter.text}")
        }, {
            counter.text = "Time is over"
        })
    }

    override fun onDestroyView() {
        timer.unsubscribe()

        super.onDestroyView()
    }
}