package by.game.binumbers.game.domain.model

import by.game.binumbers.base.BinumbersAction

sealed class GameAction : BinumbersAction {
    object Load : GameAction()
    object OnClickBack : GameAction()
    object OnPauseClick : GameAction()
    data class StartGame(val id: String) : GameAction()
    data class EndGame(val id: String) : GameAction()
    object OnUndoClick : GameAction()

    object OnMoveLeft : GameAction()
    object OnMoveRight : GameAction()
    object OnMoveDown : GameAction()
    object OnMoveUp : GameAction()

    object Resume : GameAction()
    object Start : GameAction()
    object Pause : GameAction()
}
