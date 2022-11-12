package by.game.binumbers.score.domain.usecase

import by.game.binumbers.base.model.LevelId
import by.game.binumbers.score.domain.boundary.repository.ScoreRepository

class SaveScoreUseCase(private val scoreRepository: ScoreRepository) {

    suspend operator fun invoke(scoreIndex: Int, levelId: LevelId, score: Long) {
        scoreRepository.saveScore(scoreIndex, levelId, score)
    }
}
