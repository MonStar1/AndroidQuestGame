package com.andreip.androidquestgame.level

import com.andreip.androidquestgame.BaseLevelFragment
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.state.QuestState

class Level9Fragment : BaseLevelFragment() {
    override val questState: QuestState = QuestState.LEVEL_9
    override val levelLayoutId: Int = R.layout.fragment_level_9
    override val navigateActionId: Int = R.id.action_level9Fragment_to_level10Fragment
}