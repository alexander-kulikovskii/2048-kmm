package by.game.binumbers.levels.data.repository

import by.game.binumbers.base.model.LevelId
import by.game.binumbers.levels.data.source.local.LevelsLocalDataSource
import by.game.binumbers.levels.domain.boundary.repository.LevelsRepository

class LevelsRepositoryImpl(private val levelsLocalDataSource: LevelsLocalDataSource) :
    LevelsRepository {
    override suspend fun unblockLevel(levelId: LevelId) {
        levelsLocalDataSource.unblockLevel(levelId)
    }

    override suspend fun checkUnblockedLevel(levelId: LevelId): Boolean {
        return levelsLocalDataSource.checkUnblockedLevel(levelId)
    }
}
