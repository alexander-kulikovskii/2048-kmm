package by.game.binumbers.levels.domain.model

import by.game.binumbers.base.BinumbersEffect

sealed class LevelsSideEffect : BinumbersEffect

data class Error(
    public val error: Exception,
) : LevelsSideEffect()
