package com.andreip.androidquestgame

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.andreip.androidquestgame.state.QuestState
import com.andreip.androidquestgame.widget.QuestInteractionView

abstract class BaseLevelFragment : Fragment() {
    abstract val questState: QuestState

    @get:LayoutRes
    abstract val levelLayoutId: Int

    @get:IdRes
    abstract val navigateActionId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        questStatePref.questState = questState.ordinal
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(levelLayoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonNext = view.findViewById<FloatingActionButton>(R.id.buttonNext)
        val questInteractionView = view.findViewById<QuestInteractionView>(R.id.questInteractionView)

        buttonNext.setOnClickListener {
            findNavController().navigate(navigateActionId)
        }

        questInteractionView.onAcceptListener = {
            if (it) {
                buttonNext.show()
            } else {
                buttonNext.hide()
            }
        }
    }
}