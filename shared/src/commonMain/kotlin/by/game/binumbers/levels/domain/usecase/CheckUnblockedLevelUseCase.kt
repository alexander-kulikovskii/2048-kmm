package by.game.binumbers.levels.domain.usecase

import by.game.binumbers.base.model.LevelId
import by.game.binumbers.levels.domain.boundary.repository.LevelsRepository

class CheckUnblockedLevelUseCase(private val levelsRepository: LevelsRepository) {

    suspend operator fun invoke(levelId: LevelId): Boolean {
        return levelsRepository.checkUnblockedLevel(levelId)
    }
}
