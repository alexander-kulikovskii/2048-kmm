package by.game.binumbers.settings.domain.generated

import by.game.binumbers.base.BinumbersNavigation
import by.game.binumbers.base.Store
import by.game.binumbers.settings.domain.model.SettingsAction
import by.game.binumbers.settings.domain.model.SettingsSideEffect

typealias SettingsStore = Store<SettingsState, SettingsAction, SettingsSideEffect, BinumbersNavigation>
