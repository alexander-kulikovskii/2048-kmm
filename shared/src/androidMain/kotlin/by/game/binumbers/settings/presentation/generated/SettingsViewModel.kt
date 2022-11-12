package by.game.binumbers.settings.presentation.generated

import androidx.lifecycle.ViewModel
import by.game.binumbers.settings.domain.SettingsInteractor
import by.game.binumbers.settings.domain.generated.SettingsStore
import by.game.binumbers.settings.domain.model.SettingsAction

class SettingsViewModel(
    val settingsInteractor: SettingsInteractor,
) : ViewModel(), SettingsStore {
    init {
        settingsInteractor.dispatch(SettingsAction.Load)
    }

    override fun observeState() = settingsInteractor.observeState()

    override fun observeSideEffect() = settingsInteractor.observeSideEffect()

    override fun observeNavigation() = settingsInteractor.observeNavigation()

    override fun dispatch(action: SettingsAction) {
        settingsInteractor.dispatch(action)
    }
}
