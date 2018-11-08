package com.andreip.androidquestgame.level

import com.andreip.androidquestgame.BaseLevelFragment
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.state.QuestState

class Level6Fragment : BaseLevelFragment() {
    override val questState: QuestState = QuestState.LEVEL_6
    override val levelLayoutId: Int = R.layout.fragment_level_6
    override val navigateActionId: Int = R.id.action_level6Fragment_to_level7Fragment
}