package com.andreip.androidquestgame.level

import com.andreip.androidquestgame.BaseLevelFragment
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.state.QuestState

class Level4Fragment : BaseLevelFragment() {
    override val questState: QuestState = QuestState.LEVEL_4
    override val levelLayoutId: Int = R.layout.fragment_level_4
    override val navigateActionId: Int = R.id.action_level4Fragment_to_level5Fragment
}