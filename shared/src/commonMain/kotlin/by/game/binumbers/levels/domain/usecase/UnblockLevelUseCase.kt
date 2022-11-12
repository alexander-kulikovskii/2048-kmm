package by.game.binumbers.levels.domain.usecase

import by.game.binumbers.base.model.LevelId
import by.game.binumbers.levels.domain.boundary.repository.LevelsRepository

class UnblockLevelUseCase(private val levelsRepository: LevelsRepository) {

    suspend operator fun invoke(levelId: LevelId) {
        levelsRepository.unblockLevel(levelId)
    }
}
