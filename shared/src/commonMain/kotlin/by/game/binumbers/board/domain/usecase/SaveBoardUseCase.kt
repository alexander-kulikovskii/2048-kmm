package by.game.binumbers.board.domain.usecase

import by.game.binumbers.base.model.CellId
import by.game.binumbers.base.model.LevelId
import by.game.binumbers.board.domain.boundary.repository.GameBoardRepository

class SaveBoardUseCase(
    private val gameBoardRepository: GameBoardRepository,
) {

    suspend operator fun invoke(boardIndex: Int, levelId: LevelId, cells: List<CellId>) {
        gameBoardRepository.saveBoard(boardIndex, levelId, cells)
    }
}
