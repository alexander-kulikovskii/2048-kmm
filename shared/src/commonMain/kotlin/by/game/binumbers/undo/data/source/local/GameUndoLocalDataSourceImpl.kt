package by.game.binumbers.undo.data.source.local

import by.game.binumbers.base.model.LevelId
import by.game.binumbers.base.storage.KeyValueStorage

class GameUndoLocalDataSourceImpl(private val keyValueStorage: KeyValueStorage) :
    GameUndoLocalDataSource {
    override suspend fun restoreUndoEnabled(levelId: LevelId): Boolean {
        return keyValueStorage.getBoolean("${levelId.toKey()}_enabled", false)
    }

    override suspend fun restoreUndoCount(levelId: LevelId): Long {
        return keyValueStorage.getLong("${levelId.toKey()}_count", -1L)
    }

    override suspend fun saveUndoEnabled(levelId: LevelId, enabled: Boolean) {
        keyValueStorage.saveBoolean("${levelId.toKey()}_enabled", enabled)
    }

    override suspend fun saveUndoCount(levelId: LevelId, count: Long) {
        keyValueStorage.saveLong("${levelId.toKey()}_count", count)
    }

    private fun LevelId.toKey(): String = "$KEY_PREFIX${this.id}"

    private companion object {
        private const val KEY_PREFIX = "Game_Undo_"
    }
}
