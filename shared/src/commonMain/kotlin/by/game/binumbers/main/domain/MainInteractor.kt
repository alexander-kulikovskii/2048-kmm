package by.game.binumbers.main.domain

import by.game.binumbers.base.BinumbersNavigation
import by.game.binumbers.base.extension.emitNavigation
import by.game.binumbers.base.navigation.Screen
import by.game.binumbers.base.navigation.fromScreen
import by.game.binumbers.base.navigation.toScreen
import by.game.binumbers.main.domain.generated.MainState
import by.game.binumbers.main.domain.generated.MainStore
import by.game.binumbers.main.domain.model.MainAction
import by.game.binumbers.main.domain.model.MainSideEffect
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainInteractor(
    private val interactorDispatcher: CoroutineDispatcher = Dispatchers.Default,
) : MainStore, CoroutineScope by CoroutineScope(interactorDispatcher) {

    private val state = MutableStateFlow(MainState.initial)
    private val sideEffect = MutableSharedFlow<MainSideEffect>()
    private val navigation = MutableSharedFlow<BinumbersNavigation>()

    override fun observeState(): StateFlow<MainState> = state
    override fun observeSideEffect(): Flow<MainSideEffect> = sideEffect
    override fun observeNavigation(): Flow<BinumbersNavigation> = navigation

    override fun dispatch(action: MainAction) {
        when (action) {
            MainAction.Load -> {}
            MainAction.OnClickStatistics -> openStatistics()
            MainAction.OnClickLevels -> openLevels()
            MainAction.OnClickSettings -> openSettings()
            MainAction.Pause -> {}
            MainAction.Resume -> {}
        }
    }

    private fun openStatistics() {
        launch {
            navigation.emitNavigation(
                from = Screen.Main.fromScreen(),
                to = Screen.WinOrLose.toScreen(),
                inclusiveScreen = true,
            )
        }
    }

    private fun openLevels() {
        launch {
            navigation.emitNavigation(
                from = Screen.Main.fromScreen(),
                to = Screen.Levels.toScreen(),
            )
        }
    }

    private fun openSettings() {
        launch {
            navigation.emitNavigation(
                from = Screen.Main.fromScreen(),
                to = Screen.Settings.toScreen(),
            )
        }
    }
}
