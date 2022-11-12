package by.game.binumbers.score.data.repository

import by.game.binumbers.base.model.CellId
import by.game.binumbers.base.model.LevelId
import by.game.binumbers.score.data.source.local.ScoreLocalDataSource
import by.game.binumbers.score.domain.boundary.repository.ScoreRepository

class ScoreRepositoryImpl(private val scoreLocalDataSource: ScoreLocalDataSource) :
    ScoreRepository {
    override suspend fun restoreScore(scoreIndex: Int, levelId: LevelId): Long =
        scoreLocalDataSource.restoreScore(scoreIndex, levelId)

    override suspend fun restoreMaxCellId(levelId: LevelId): CellId {
        return scoreLocalDataSource.restoreMaxCellId(levelId)
    }

    override suspend fun saveScore(scoreIndex: Int, levelId: LevelId, score: Long) {
        scoreLocalDataSource.saveScore(scoreIndex, levelId, score)
    }

    override suspend fun saveMaxCellId(levelId: LevelId, cellId: CellId) {
        scoreLocalDataSource.saveMaxCellId(levelId, cellId)
    }
}
