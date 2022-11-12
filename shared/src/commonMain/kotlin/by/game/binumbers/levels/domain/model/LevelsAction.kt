package by.game.binumbers.levels.domain.model

import by.game.binumbers.base.BinumbersAction
import by.game.binumbers.base.model.LevelId

sealed class LevelsAction : BinumbersAction {
    object Load : LevelsAction()
    object OnClickBack : LevelsAction()
    data class OnClickLevel(val id: LevelId) : LevelsAction()
}
