package by.game.binumbers.tutorial.domain.model

import by.game.binumbers.base.BinumbersEffect

sealed class TutorialSideEffect : BinumbersEffect

data class Error(
    public val error: Exception,
) : TutorialSideEffect()
