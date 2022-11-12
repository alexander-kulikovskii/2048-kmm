package by.game.binumbers.settings.domain.generated

import by.game.binumbers.base.BinumbersState
import kotlin.Boolean

data class SettingsState(
    val progress: Boolean,
    val darkThemeEnable: Boolean,
    val dynamicColorsEnable: Boolean,
    val dynamicColorsSupported: Boolean,
    val vibrationsEnable: Boolean,
) : BinumbersState {
    companion object {
        val initial: SettingsState = SettingsState(
            progress = false,
            darkThemeEnable = false,
            dynamicColorsEnable = true,
            dynamicColorsSupported = false,
            vibrationsEnable = true,
        )
    }
}
