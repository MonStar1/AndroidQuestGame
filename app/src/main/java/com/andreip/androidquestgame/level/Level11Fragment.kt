package com.andreip.androidquestgame.level

import com.andreip.androidquestgame.BaseLevelFragment
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.state.QuestState

class Level11Fragment : BaseLevelFragment() {
    override val questState: QuestState = QuestState.LEVEL_11
    override val levelLayoutId: Int = R.layout.fragment_level_11
    override val navigateActionId: Int = 0
}