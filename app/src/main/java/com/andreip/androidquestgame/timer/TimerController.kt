package com.andreip.androidquestgame.timer

import android.os.CountDownTimer
import com.andreip.androidquestgame.timerPref

class TimerController(private val tag: String) {

    var countDownTimer: CountDownTimer? = null

    fun startNow(timerLimitInSeconds: Long) {
        if (isTimerStarted()) {
            throw IllegalStateException("You can't start the same timer twice. Use subscribe(..) to get updates of current timer")
        }

        timerPref.setStartTime(tag, System.currentTimeMillis())
        timerPref.setTimerLimitInMillis(tag, timerLimitInSeconds * 1000)
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

    fun isTimerStarted() = timerPref.getStartTime(tag) > 0

    fun isTimeOver() = getEndTime() < System.currentTimeMillis()

    fun getTimeLeft(): Long {
        val timeLeft = getEndTime() - System.currentTimeMillis()

        return if (timeLeft < 0) 0 else timeLeft
    }

    private fun getEndTime() = timerPref.getStartTime(tag) + timerPref.getTimerLimitInMillis(tag)

    fun clear() {
        timerPref.setStartTime(tag, 0)
        timerPref.setTimerLimitInMillis(tag, 0)
    }

    fun convertMillisToTime(millis: Long): String {
        val second = millis / 1000 % 60
        val minute = millis / (1000 * 60) % 60
        val hour = millis / (1000 * 60 * 60) % 24

        return String.format("%02d : %02d : %02d", hour, minute, second)
    }
}