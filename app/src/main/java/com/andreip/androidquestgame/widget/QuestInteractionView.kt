package com.andreip.androidquestgame.widget

import android.content.Context
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.timer.TimerController
import com.andreip.androidquestgame.util.hideKeyboard
import com.andreip.androidquestgame.util.visible
import kotlinx.android.synthetic.main.view_quest_interaction.view.*

class QuestInteractionView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val hintTag: String
    private val hintTimeInSeconds: Int
    private val hintText: String
    private val rightCodes = mutableListOf<CharSequence>()

    @DrawableRes
    private val hintImage: Int

    private val timer: TimerController

    var onAcceptListener: ((Boolean) -> Unit)? = null

    init {
        View.inflate(context, R.layout.view_quest_interaction, this)

        val attributes = context.theme.obtainStyledAttributes(attrs, R.styleable.QuestInteractionView, defStyleAttr, 0)

        hintTag = attributes.getString(R.styleable.QuestInteractionView_hintTag)!!
//        hintTimeInSeconds = attributes.getInteger(R.styleable.QuestInteractionView_hintTimeInSeconds, 0)
        hintTimeInSeconds = 2 // TODO remove later
        hintText = attributes.getString(R.styleable.QuestInteractionView_hintText) ?: ""
        hintImage = attributes.getResourceId(R.styleable.QuestInteractionView_hintImage, 0)
        rightCodes.addAll(attributes.getTextArray(R.styleable.QuestInteractionView_rightCodes).toList())

        attributes.recycle()

        timer = TimerController(hintTag)
//        timer.clear()//TODO remove later

        if (!timer.isTimerStarted()) {
            timer.startNow(hintTimeInSeconds.toLong())
        }

        if (timer.isTimeOver()) {
            helpView.visible()
        }

        accept.setOnClickListener {
            if (rightCodes.contains(code.text.toString())) {
                code.hideKeyboard()
                textInputLayout.isErrorEnabled = false
                postDelayed({
                    onAcceptListener?.invoke(true)
                }, 1000)
            } else {
                onAcceptListener?.invoke(false)
                textInputLayout.error = "Введите правильный код"
                textInputLayout.isErrorEnabled = true
            }
        }

        textHelp.text = hintText
        imageHelp.setImageResource(hintImage)

        if (isInEditMode) {
            helpView.visible()
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        timer.subscribe({
            counter.text = timer.convertMillisToTime(it)
        }, {
            helpView.visible()
        })
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

        timer.unsubscribe()
    }

    fun addRightCodes(codes: Array<String>) {
        rightCodes.addAll(codes)
    }
}