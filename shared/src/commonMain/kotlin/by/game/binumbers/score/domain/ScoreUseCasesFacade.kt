package by.game.binumbers.score.domain

import by.game.binumbers.base.model.LevelId

interface ScoreUseCasesFacade {
    suspend fun restoreCurrentScore(levelId: LevelId): Long

    suspend fun restorePreviousScore(levelId: LevelId): Long

    suspend fun saveCurrentScore(levelId: LevelId, score: Long)

    suspend fun savePreviousScore(levelId: LevelId, score: Long)
}
