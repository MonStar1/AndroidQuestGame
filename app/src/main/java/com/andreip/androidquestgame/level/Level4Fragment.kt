package com.andreip.androidquestgame.level

import android.os.Bundle
import android.view.View
import com.andreip.androidquestgame.BaseLevelFragment
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.questStatePref
import com.andreip.androidquestgame.state.QuestState
import kotlinx.android.synthetic.main.fragment_level_4.*

class Level4Fragment : BaseLevelFragment() {
    override val questState: QuestState = QuestState.LEVEL_4
    override val levelLayoutId: Int = R.layout.fragment_level_4
    override val navigateActionId: Int = R.id.action_level4Fragment_to_level404Fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        questInteractionView.addRightCodes(arrayOf(questStatePref.level4Code))
    }
}