package com.andreip.androidquestgame.level

import com.andreip.androidquestgame.BaseLevelFragment
import com.andreip.androidquestgame.R
import com.andreip.androidquestgame.state.QuestState

class LevelLastFragment : BaseLevelFragment() {
    override val questState: QuestState = QuestState.LEVEL_LAST
    override val levelLayoutId: Int = R.layout.fragment_level_last
    override val navigateActionId: Int = R.id.action_levelLastFragment_to_levelWonFragment
}