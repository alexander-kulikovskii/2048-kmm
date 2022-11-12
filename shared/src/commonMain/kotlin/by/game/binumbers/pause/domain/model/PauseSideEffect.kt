package by.game.binumbers.pause.domain.model

import by.game.binumbers.base.BinumbersEffect

sealed class PauseSideEffect : BinumbersEffect

data class Error(
    public val error: Exception,
) : PauseSideEffect()
