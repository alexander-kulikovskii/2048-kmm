package by.game.binumbers.levels.data.source.local

import by.game.binumbers.base.model.LevelId
import by.game.binumbers.base.storage.KeyValueStorage

class LevelsLocalDataSourceImpl(private val keyValueStorage: KeyValueStorage) :
    LevelsLocalDataSource {

    override suspend fun unblockLevel(levelId: LevelId) {
        keyValueStorage.saveBoolean(levelId.toKey(), true)
    }

    override suspend fun checkUnblockedLevel(levelId: LevelId): Boolean {
        return keyValueStorage.getBoolean(
            levelId.toKey(),
            defaultValue = defaultValueForLevel(levelId)
        )
    }

    private fun defaultValueForLevel(levelId: LevelId): Boolean {
        return when (levelId) {
            LevelId.L_2048 -> true
            LevelId.L_4096 -> false
            LevelId.L_8192 -> false
            LevelId.L_UNLIMITED -> false
            LevelId.L_TIME -> false
            else -> false
        }
    }

    private fun LevelId.toKey(): String = "$KEY_PREFIX${this.id}"

    private companion object {
        private const val KEY_PREFIX = "Levels_"
    }
}
