package com.andreip.androidquestgame.level

import com.andreip.androidquestgame.BaseLevelFragment
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.state.QuestState

class Level2Fragment : BaseLevelFragment() {
    override val questState: QuestState = QuestState.LEVEL_2
    override val levelLayoutId: Int = R.layout.fragment_level_2
    override val navigateActionId: Int = R.id.action_level2Fragment_to_level3Fragment
}