package by.game.binumbers.levels.domain.boundary.repository

import by.game.binumbers.base.model.LevelId

interface LevelsRepository {

    suspend fun unblockLevel(levelId: LevelId)

    suspend fun checkUnblockedLevel(levelId: LevelId): Boolean
}
