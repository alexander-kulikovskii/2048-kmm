package by.game.binumbers.undo.domain

import by.game.binumbers.base.model.LevelId

interface UndoUseCasesFacade {

    suspend fun saveUndoEnabled(levelId: LevelId, undoEnabled: Boolean)

    suspend fun restoreUndoEnabled(levelId: LevelId): Boolean

    suspend fun saveUndoCount(levelId: LevelId, undoCount: Long)

    suspend fun restoreUndoCount(levelId: LevelId): Long
}
