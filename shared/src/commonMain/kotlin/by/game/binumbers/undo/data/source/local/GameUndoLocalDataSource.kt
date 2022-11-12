package by.game.binumbers.undo.data.source.local

import by.game.binumbers.base.model.LevelId

interface GameUndoLocalDataSource {
    suspend fun restoreUndoEnabled(levelId: LevelId): Boolean

    suspend fun restoreUndoCount(levelId: LevelId): Long

    suspend fun saveUndoEnabled(levelId: LevelId, enabled: Boolean)

    suspend fun saveUndoCount(levelId: LevelId, count: Long)
}
