package by.game.binumbers.levels.domain.generated

import by.game.binumbers.base.BinumbersState
import kotlin.Boolean

data class LevelsState(
    val progress: Boolean,
    val level2048Enable: Boolean,
    val level4096Enable: Boolean,
    val level8192Enable: Boolean,
    val levelUnlimitedEnable: Boolean,
//    val levelTimeEnable: Boolean, // TODO next release
) : BinumbersState {
    companion object {
        val initial: LevelsState = LevelsState(
            progress = false,
            level2048Enable = true,
            level4096Enable = false,
            level8192Enable = false,
            levelUnlimitedEnable = false,
        )
    }
}
