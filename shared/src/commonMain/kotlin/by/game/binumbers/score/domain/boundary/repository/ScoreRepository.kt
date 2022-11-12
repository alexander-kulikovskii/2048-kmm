package by.game.binumbers.score.domain.boundary.repository

import by.game.binumbers.base.model.CellId
import by.game.binumbers.base.model.LevelId

interface ScoreRepository {

    suspend fun restoreScore(scoreIndex: Int, levelId: LevelId): Long

    suspend fun restoreMaxCellId(levelId: LevelId): CellId

    suspend fun saveScore(scoreIndex: Int, levelId: LevelId, score: Long)

    suspend fun saveMaxCellId(levelId: LevelId, cellId: CellId)
}
