package com.andreip.androidquestgame.level

import com.andreip.androidquestgame.BaseLevelFragment
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.state.QuestState

class Level404Fragment : BaseLevelFragment() {
    override val questState: QuestState = QuestState.LEVEL_404
    override val levelLayoutId: Int = R.layout.fragment_level_404
    override val navigateActionId: Int = R.id.action_level404Fragment_to_level5Fragment
}