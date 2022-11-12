package by.game.binumbers.pause.domain.generated

import `by`.game.binumbers.base.BinumbersState
import kotlin.Boolean

data class PauseState(
    val progress: Boolean,
) : BinumbersState {
    companion object {
        val initial: PauseState = PauseState(false)
    }
}
