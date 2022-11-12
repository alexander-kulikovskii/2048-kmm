package by.game.binumbers.board.domain

import by.game.binumbers.base.model.Area
import by.game.binumbers.base.model.CellId
import by.game.binumbers.base.model.LevelId
import by.game.binumbers.board.domain.usecase.RestoreOrCreateBoardUseCase
import by.game.binumbers.board.domain.usecase.SaveBoardUseCase

class BoardUseCasesFacadeImpl(
    private val restoreOrCreateBoardUseCase: RestoreOrCreateBoardUseCase,
    private val saveBoardUseCase: SaveBoardUseCase,
) : BoardUseCasesFacade {
    override suspend fun restoreOrCreateCurrentBoard(levelId: LevelId): Area {
        return restoreOrCreateBoardUseCase(CURRENT_INDEX, levelId)
    }

    override suspend fun restoreOrCreatePreviousBoard(levelId: LevelId): Area {
        return restoreOrCreateBoardUseCase(PREV_INDEX, levelId)
    }

    override suspend fun saveCurrentBoard(levelId: LevelId, cells: List<CellId>) {
        saveBoardUseCase(CURRENT_INDEX, levelId, cells)
    }

    override suspend fun savePreviousBoard(levelId: LevelId, cells: List<CellId>) {
        saveBoardUseCase(PREV_INDEX, levelId, cells)
    }

    private companion object {
        private const val CURRENT_INDEX = 0
        private const val PREV_INDEX = 1
    }
}
