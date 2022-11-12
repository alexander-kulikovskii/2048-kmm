package by.game.binumbers.score.domain

import by.game.binumbers.base.model.LevelId
import by.game.binumbers.score.domain.usecase.RestoreScoreUseCase
import by.game.binumbers.score.domain.usecase.SaveScoreUseCase

class ScoreUseCasesFacadeImpl(
    private val restoreScoreUseCase: RestoreScoreUseCase,
    private val saveScoreUseCase: SaveScoreUseCase,
) : ScoreUseCasesFacade {
    override suspend fun restoreCurrentScore(levelId: LevelId): Long {
        return restoreScoreUseCase(CURRENT_INDEX, levelId)
    }

    override suspend fun restorePreviousScore(levelId: LevelId): Long {
        return restoreScoreUseCase(PREV_INDEX, levelId)
    }

    override suspend fun saveCurrentScore(levelId: LevelId, score: Long) {
        saveScoreUseCase(CURRENT_INDEX, levelId, score)
    }

    override suspend fun savePreviousScore(levelId: LevelId, score: Long) {
        saveScoreUseCase(PREV_INDEX, levelId, score)
    }

    private companion object {
        private const val CURRENT_INDEX = 0
        private const val PREV_INDEX = 1
    }
}
