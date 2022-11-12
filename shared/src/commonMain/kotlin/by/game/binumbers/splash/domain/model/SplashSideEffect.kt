package by.game.binumbers.splash.domain.model

import by.game.binumbers.base.BinumbersEffect

sealed class SplashSideEffect : BinumbersEffect {
    object NoInternetConnection : SplashSideEffect()
}

data class Error(
    public val error: Exception,
) : SplashSideEffect()
