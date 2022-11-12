package by.game.binumbers.board.data.source.local

import by.game.binumbers.base.model.CellId
import by.game.binumbers.base.model.LevelId

interface GameBoardLocalDataSource {

    suspend fun restoreBoard(boardIndex: Int, levelId: LevelId, size: Int): List<CellId>

    suspend fun saveBoard(boardIndex: Int, levelId: LevelId, cells: List<CellId>)
}
