package by.game.binumbers.board.data.repository

import by.game.binumbers.base.model.CellId
import by.game.binumbers.base.model.LevelId
import by.game.binumbers.board.data.source.local.GameBoardLocalDataSource
import by.game.binumbers.board.domain.boundary.repository.GameBoardRepository

class GameBoardRepositoryImpl(private val gameBoardLocalDataSource: GameBoardLocalDataSource) :
    GameBoardRepository {
    override suspend fun restoreBoard(boardIndex: Int, levelId: LevelId, size: Int): List<CellId> =
        gameBoardLocalDataSource.restoreBoard(boardIndex, levelId, size)

    override suspend fun saveBoard(boardIndex: Int, levelId: LevelId, cells: List<CellId>) {
        gameBoardLocalDataSource.saveBoard(boardIndex, levelId, cells)
    }
}
