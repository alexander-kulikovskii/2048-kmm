package by.game.binumbers.board.domain.boundary.repository

import by.game.binumbers.base.model.CellId
import by.game.binumbers.base.model.LevelId

interface GameBoardRepository {

    suspend fun restoreBoard(boardIndex: Int, levelId: LevelId, size: Int): List<CellId>

    suspend fun saveBoard(boardIndex: Int, levelId: LevelId, cells: List<CellId>)
}
