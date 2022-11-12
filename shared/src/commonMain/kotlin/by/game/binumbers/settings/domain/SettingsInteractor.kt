package by.game.binumbers.settings.domain

import by.game.binumbers.base.BinumbersNavigation
import by.game.binumbers.base.extension.emitPopBack
import by.game.binumbers.base.navigation.Screen
import by.game.binumbers.base.navigation.fromScreen
import by.game.binumbers.base.navigation.toScreen
import by.game.binumbers.settings.domain.generated.SettingsState
import by.game.binumbers.settings.domain.generated.SettingsStore
import by.game.binumbers.settings.domain.model.SettingsAction
import by.game.binumbers.settings.domain.model.SettingsSideEffect
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.job
import kotlinx.coroutines.launch

class SettingsInteractor(
    private val interactorDispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val settingsUseCasesFacade: SettingsUseCasesFacade,
) : SettingsStore, CoroutineScope by CoroutineScope(interactorDispatcher) {

    private val state = MutableStateFlow(SettingsState.initial)
    private val sideEffect = MutableSharedFlow<SettingsSideEffect>()
    private val navigation = MutableSharedFlow<BinumbersNavigation>()

    override fun observeState(): StateFlow<SettingsState> = state
    override fun observeSideEffect(): Flow<SettingsSideEffect> = sideEffect
    override fun observeNavigation(): Flow<BinumbersNavigation> = navigation

    override fun dispatch(action: SettingsAction) {

        val oldState = state.value
        when (action) {
            is SettingsAction.Load -> {
                state.value = state.value.copy(progress = true)
                launch {
                    state.value = oldState.copy(
                        progress = false,
                        darkThemeEnable = settingsUseCasesFacade.restoreDarkMode(),
                        dynamicColorsEnable = settingsUseCasesFacade.restoreDynamicThemeMode(),
                        dynamicColorsSupported = settingsUseCasesFacade.restoreIsDynamicThemeSupported(),
                        vibrationsEnable = settingsUseCasesFacade.restoreVibrationEnabled(),
                    )
                }
            }
            is SettingsAction.OnClickBack -> {
                launch {
                    this.coroutineContext.job.cancelChildren() // TODO ???
                    navigation.emitPopBack(
                        from = Screen.Settings.fromScreen(),
                        to = Screen.Main.toScreen(),
                    )
                }
            }
            is SettingsAction.OnDarkThemeClick -> {
                launch {
                    state.value = oldState.copy(
                        darkThemeEnable = !oldState.darkThemeEnable,
                    )
                }
            }
            is SettingsAction.OnDynamicColorsClick -> {
                launch {
                    state.value = oldState.copy(
                        dynamicColorsEnable = !oldState.dynamicColorsEnable,
                    )
                }
            }
        }
    }
}
