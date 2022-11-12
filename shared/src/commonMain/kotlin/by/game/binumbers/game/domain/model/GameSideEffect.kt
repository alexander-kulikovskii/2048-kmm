package by.game.binumbers.game.domain.model

import by.game.binumbers.base.BinumbersEffect

sealed class GameSideEffect : BinumbersEffect

data class Error(
    public val error: Exception,
) : GameSideEffect()
