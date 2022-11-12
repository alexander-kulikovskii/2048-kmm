package by.game.binumbers.main.domain.model

import by.game.binumbers.base.BinumbersEffect

sealed class MainSideEffect : BinumbersEffect

data class Error(
    public val error: Exception,
) : MainSideEffect()
