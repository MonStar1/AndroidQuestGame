package com.andreip.androidquestgame.level

import com.andreip.androidquestgame.BaseLevelFragment
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.state.QuestState

class LevelWonFragment : BaseLevelFragment() {
    override val questState: QuestState = QuestState.LEVEL_WON
    override val levelLayoutId: Int = R.layout.fragment_won
    override val navigateActionId: Int = R.id.action_level10Fragment_to_level11Fragment
}