package com.andreip.androidquestgame.level

import com.andreip.androidquestgame.BaseLevelFragment
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.state.QuestState

class Level8Fragment : BaseLevelFragment() {
    override val questState: QuestState = QuestState.LEVEL_8
    override val levelLayoutId: Int = R.layout.fragment_level_8
    override val navigateActionId: Int = R.id.action_level8Fragment_to_level9Fragment
}