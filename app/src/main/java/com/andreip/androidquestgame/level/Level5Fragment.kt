package com.andreip.androidquestgame.level

import com.andreip.androidquestgame.BaseLevelFragment
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.state.QuestState

class Level5Fragment : BaseLevelFragment() {
    override val questState: QuestState = QuestState.LEVEL_5
    override val levelLayoutId: Int = R.layout.fragment_level_5
    override val navigateActionId: Int = R.id.action_level5Fragment_to_level6Fragment
}