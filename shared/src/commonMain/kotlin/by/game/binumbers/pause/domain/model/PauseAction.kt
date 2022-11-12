package by.game.binumbers.pause.domain.model

import by.game.binumbers.base.BinumbersAction

sealed class PauseAction : BinumbersAction {
    object Load : PauseAction()
    object Resume : PauseAction()
    object Pause : PauseAction()
    object OnClickBack : PauseAction()
    object OnClickResume : PauseAction()
    object OnClickSettings : PauseAction()
    object OnClickBackToLevels : PauseAction()
    object OnClickStatistics : PauseAction()
    object OnClickRestart : PauseAction()
}
