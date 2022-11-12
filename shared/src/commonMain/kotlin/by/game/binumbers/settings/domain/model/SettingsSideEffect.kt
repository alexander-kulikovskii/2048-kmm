package by.game.binumbers.settings.domain.model

import by.game.binumbers.base.BinumbersEffect

sealed class SettingsSideEffect : BinumbersEffect

data class Error(
    public val error: Exception,
) : SettingsSideEffect()
