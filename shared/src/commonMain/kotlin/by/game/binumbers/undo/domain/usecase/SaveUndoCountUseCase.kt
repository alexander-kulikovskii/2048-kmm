package by.game.binumbers.undo.domain.usecase

import by.game.binumbers.base.model.LevelId
import by.game.binumbers.undo.domain.boundary.repository.GameUndoRepository

class SaveUndoCountUseCase(
    private val gameUndoRepository: GameUndoRepository,
) {

    suspend operator fun invoke(levelId: LevelId, undoCount: Long) {
        gameUndoRepository.saveUndoCount(levelId, undoCount)
    }
}
