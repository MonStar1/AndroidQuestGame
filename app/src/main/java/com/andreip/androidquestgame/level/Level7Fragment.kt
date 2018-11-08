package com.andreip.androidquestgame.level

import com.andreip.androidquestgame.BaseLevelFragment
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.state.QuestState

class Level7Fragment : BaseLevelFragment() {
    override val questState: QuestState = QuestState.LEVEL_7
    override val levelLayoutId: Int = R.layout.fragment_level_7
    override val navigateActionId: Int = R.id.action_level7Fragment_to_level8Fragment
}