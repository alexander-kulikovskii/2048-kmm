package by.game.binumbers.tutorial.domain.generated

import by.game.binumbers.base.BinumbersState
import kotlin.Boolean

public data class TutorialState(
    public val progress: Boolean,
) : BinumbersState {
    public companion object {
        public val initial: TutorialState = TutorialState(false)
    }
}
