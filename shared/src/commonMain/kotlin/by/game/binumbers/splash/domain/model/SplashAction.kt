package by.game.binumbers.splash.domain.model

import by.game.binumbers.base.BinumbersAction

sealed class SplashAction : BinumbersAction {
    object Load : SplashAction()
    object Resume : SplashAction()
    object Pause : SplashAction()
}
