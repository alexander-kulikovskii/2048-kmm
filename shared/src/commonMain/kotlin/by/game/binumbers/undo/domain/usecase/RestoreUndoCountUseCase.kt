package by.game.binumbers.undo.domain.usecase

import by.game.binumbers.base.model.LevelId
import by.game.binumbers.undo.domain.boundary.repository.GameUndoRepository

class RestoreUndoCountUseCase(
    private val gameUndoRepository: GameUndoRepository,
) {

    suspend operator fun invoke(levelId: LevelId): Long {
        val repoValue = gameUndoRepository.restoreUndoCount(levelId)
        return if (repoValue == -1L) {
            levelId.maxUndoCount
        } else {
            repoValue
        }
    }
}
