package by.game.binumbers.score.data.source.local

import by.game.binumbers.base.model.CellId
import by.game.binumbers.base.model.LevelId
import by.game.binumbers.base.storage.KeyValueStorage

class ScoreLocalDataSourceImpl(private val keyValueStorage: KeyValueStorage) :
    ScoreLocalDataSource {
    override suspend fun restoreScore(scoreIndex: Int, levelId: LevelId): Long {
        return keyValueStorage.getLong(levelId.toScoreKey(scoreIndex))
    }

    override suspend fun restoreMaxCellId(levelId: LevelId): CellId {
        return CellId.getCellIdById(keyValueStorage.getInt(levelId.toMaxCellKey()))
    }

    override suspend fun saveScore(scoreIndex: Int, levelId: LevelId, score: Long) {
        keyValueStorage.saveLong(levelId.toScoreKey(scoreIndex), score)
    }

    override suspend fun saveMaxCellId(levelId: LevelId, cellId: CellId) {
        keyValueStorage.saveInt(levelId.toMaxCellKey(), cellId.id)
    }

    private fun LevelId.toScoreKey(scoreIndex: Int): String =
        "${scoreIndex}_${KEY_PREFIX}${this.id}_Score"

    private fun LevelId.toMaxCellKey(): String = "${KEY_PREFIX}${this.id}_Max_Cell"

    private companion object {
        private const val KEY_PREFIX = "Score_"
    }
}
