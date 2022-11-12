package by.game.binumbers.main.domain.generated

import `by`.game.binumbers.base.BinumbersState
import kotlin.Boolean

data class MainState(
    val progress: Boolean,
) : BinumbersState {
    companion object {
        val initial: MainState = MainState(false)
    }
}
