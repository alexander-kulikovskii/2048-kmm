package by.game.binumbers.game.domain.boundary.repository

import by.game.binumbers.base.model.LevelId

interface GameStatisticsRepository {

    suspend fun incNumberOfGames(levelId: LevelId)

    suspend fun incWinNumberOfGames(levelId: LevelId)

    suspend fun getNumberOfGames(levelId: LevelId)

    suspend fun getWinNumberOfGames(levelId: LevelId)
}
