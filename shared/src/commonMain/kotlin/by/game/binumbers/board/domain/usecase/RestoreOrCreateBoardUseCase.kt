package by.game.binumbers.board.domain.usecase

import by.game.binumbers.base.model.Area
import by.game.binumbers.base.model.CellId
import by.game.binumbers.base.model.LevelId
import by.game.binumbers.base.model.Randomizer
import by.game.binumbers.board.domain.boundary.repository.GameBoardRepository

class RestoreOrCreateBoardUseCase(
    private val gameBoardRepository: GameBoardRepository,
    private val randomizer: Randomizer,
) {

    suspend operator fun invoke(boardIndex: Int, levelId: LevelId): Area {
        return try {
            val cellsFromStore = gameBoardRepository.restoreBoard(boardIndex, levelId, levelId.width * levelId.height)
            if (cellsFromStore.all { it == CellId.C_EMPTY }) {
                Area(levelId).apply {
                    addRandomCell(randomizer)
                    addRandomCell(randomizer)
                }
            } else {
                Area(levelId).apply {
                    cellsFromStore.forEachIndexed { index, cellId ->
                        setCell(cellId, index)
                    }
                }
            }
        } catch (_: Exception) {
            Area(levelId)
        }
    }
}
