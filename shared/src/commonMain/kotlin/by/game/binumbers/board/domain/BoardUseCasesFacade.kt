package by.game.binumbers.board.domain

import by.game.binumbers.base.model.Area
import by.game.binumbers.base.model.CellId
import by.game.binumbers.base.model.LevelId

interface BoardUseCasesFacade {

    suspend fun restoreOrCreateCurrentBoard(levelId: LevelId): Area

    suspend fun restoreOrCreatePreviousBoard(levelId: LevelId): Area

    suspend fun saveCurrentBoard(levelId: LevelId, cells: List<CellId>)

    suspend fun savePreviousBoard(levelId: LevelId, cells: List<CellId>)
}
