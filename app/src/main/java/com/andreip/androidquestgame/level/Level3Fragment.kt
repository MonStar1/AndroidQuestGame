package com.andreip.androidquestgame.level

import com.andreip.androidquestgame.BaseLevelFragment
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.state.QuestState

class Level3Fragment : BaseLevelFragment() {
    override val questState: QuestState = QuestState.LEVEL_3
    override val levelLayoutId: Int = R.layout.fragment_level_3
    override val navigateActionId: Int = R.id.action_level3Fragment_to_level4Fragment
}