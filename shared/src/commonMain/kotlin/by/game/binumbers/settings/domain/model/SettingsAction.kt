package by.game.binumbers.settings.domain.model

import by.game.binumbers.base.BinumbersAction

sealed class SettingsAction : BinumbersAction {
    object Load : SettingsAction()
    object OnClickBack : SettingsAction()
    object OnDarkThemeClick : SettingsAction()
    object OnDynamicColorsClick : SettingsAction()
}
