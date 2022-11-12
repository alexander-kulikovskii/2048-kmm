package by.game.binumbers.undo.domain

import by.game.binumbers.base.model.LevelId
import by.game.binumbers.undo.domain.usecase.RestoreUndoCountUseCase
import by.game.binumbers.undo.domain.usecase.RestoreUndoEnabledUseCase
import by.game.binumbers.undo.domain.usecase.SaveUndoCountUseCase
import by.game.binumbers.undo.domain.usecase.SaveUndoEnabledUseCase

class UndoUseCasesFacadeImpl(
    private val saveUndoCountUseCase: SaveUndoCountUseCase,
    private val saveUndoEnabledUseCase: SaveUndoEnabledUseCase,
    private val restoreUndoCountUseCase: RestoreUndoCountUseCase,
    private val restoreUndoEnabledUseCase: RestoreUndoEnabledUseCase,
) : UndoUseCasesFacade {
    override suspend fun saveUndoEnabled(levelId: LevelId, undoEnabled: Boolean) {
        saveUndoEnabledUseCase(levelId = levelId, undoEnabled = undoEnabled)
    }

    override suspend fun restoreUndoEnabled(levelId: LevelId): Boolean {
        return restoreUndoEnabledUseCase(levelId = levelId)
    }

    override suspend fun saveUndoCount(levelId: LevelId, undoCount: Long) {
        saveUndoCountUseCase(levelId = levelId, undoCount = undoCount)
    }

    override suspend fun restoreUndoCount(levelId: LevelId): Long {
        return restoreUndoCountUseCase(levelId = levelId)
    }
}
