package by.game.binumbers.splash.domain.generated

import `by`.game.binumbers.base.BinumbersState
import kotlin.Boolean

data class SplashState(
    val progress: Boolean,
) : BinumbersState {
    companion object {
        val initial: SplashState = SplashState(true)
    }
}
