package by.game.binumbers.main.domain.model

import by.game.binumbers.base.BinumbersAction

sealed class MainAction : BinumbersAction {
    object Load : MainAction()
    object Resume : MainAction()
    object Pause : MainAction()
    object OnClickSettings : MainAction()
    object OnClickLevels : MainAction()
    object OnClickStatistics : MainAction()
}
