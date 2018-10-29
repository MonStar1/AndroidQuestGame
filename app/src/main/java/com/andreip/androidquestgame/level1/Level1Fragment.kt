package com.andreip.androidquestgame.level1

import com.andreip.androidquestgame.BaseLevelFragment
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.state.QuestState

class Level1Fragment : BaseLevelFragment() {
    override val questState: QuestState = QuestState.LEVEL_1
    override val levelLayoutId: Int = R.layout.fragment_level_1
    override val navigateActionId: Int = R.id.action_level1Fragment_to_level2Fragment
}