package com.andreip.androidquestgame.timer

import android.os.CountDownTimer
import com.andreip.androidquestgame.timerPref

class TimerController(val tag: String) {

    var countDownTimer: CountDownTimer? = null

    fun startNow(timerLimitInSeconds: Long) {
        if (isTimerStarted()) {
            throw IllegalStateException("You can't start the same timer twice. Use subscribe(..) to get updates of current timer")
        }

        timerPref.startTime = System.currentTimeMillis()
        timerPref.timerLimitInMillis = timerLimitInSeconds * 1000
    }

    fun subscribe(timeLeftListener: (Long) -> Unit, timeIsOverListener: () -> Unit) {
        countDownTimer = object : CountDownTimer(getTimeLeft(), 500) {

            override fun onFinish() {
                timeIsOverListener.invoke()
            }

            override fun onTick(millisUntilFinished: Long) {
                timeLeftListener.invoke(millisUntilFinished)
            }

        }

        countDownTimer?.start()
    }

    fun unsubscribe() {
        countDownTimer?.cancel()
    }

    fun isTimerStarted() = timerPref.startTime > 0

    fun isTimeOver() = getEndTime() < System.currentTimeMillis()

    fun getTimeLeft(): Long {
        val timeLeft = getEndTime() - System.currentTimeMillis()

        return if (timeLeft < 0) 0 else timeLeft
    }

    private fun getEndTime() = timerPref.startTime + timerPref.timerLimitInMillis

    fun clear() {
        timerPref.startTime = 0
        timerPref.timerLimitInMillis = 0
    }
}