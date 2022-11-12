package by.game.binumbers.undo.data.repository

import by.game.binumbers.base.model.LevelId
import by.game.binumbers.undo.data.source.local.GameUndoLocalDataSource
import by.game.binumbers.undo.domain.boundary.repository.GameUndoRepository

class GameUndoRepositoryImpl(private val gameUndoLocalDataSource: GameUndoLocalDataSource) :
    GameUndoRepository {
    override suspend fun restoreUndoEnabled(levelId: LevelId): Boolean {
        return gameUndoLocalDataSource.restoreUndoEnabled(levelId)
    }

    override suspend fun restoreUndoCount(levelId: LevelId): Long {
        return gameUndoLocalDataSource.restoreUndoCount(levelId)
    }

    override suspend fun saveUndoEnabled(levelId: LevelId, enabled: Boolean) {
        gameUndoLocalDataSource.saveUndoEnabled(levelId, enabled)
    }

    override suspend fun saveUndoCount(levelId: LevelId, count: Long) {
        gameUndoLocalDataSource.saveUndoCount(levelId, count)
    }
}
