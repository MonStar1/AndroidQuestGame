package com.andreip.androidquestgame.intro

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.questStatePref
import com.andreip.androidquestgame.state.QuestState
import kotlinx.android.synthetic.main.fragment_intro.*

class IntroFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        buttonNext.setOnClickListener {
            findNavController().navigate(R.id.action_introFragment_to_level1Fragment)
        }
    }
}