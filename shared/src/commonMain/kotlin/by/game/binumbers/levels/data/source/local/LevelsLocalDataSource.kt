package by.game.binumbers.levels.data.source.local

import by.game.binumbers.base.model.LevelId

interface LevelsLocalDataSource {

    suspend fun unblockLevel(levelId: LevelId)

    suspend fun checkUnblockedLevel(levelId: LevelId): Boolean
}
