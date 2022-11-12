package by.game.binumbers.splash.domain

import by.game.binumbers.base.BinumbersNavigation
import by.game.binumbers.base.extension.emitNavigation
import by.game.binumbers.base.navigation.Screen
import by.game.binumbers.base.navigation.fromScreen
import by.game.binumbers.base.navigation.toScreen
import by.game.binumbers.splash.domain.generated.SplashState
import by.game.binumbers.splash.domain.generated.SplashStore
import by.game.binumbers.splash.domain.model.SplashAction
import by.game.binumbers.splash.domain.model.SplashSideEffect
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashInteractor(
    val interactorDispatcher: CoroutineDispatcher = Dispatchers.Main,
) : SplashStore, CoroutineScope by CoroutineScope(interactorDispatcher) {

    private val state = MutableStateFlow(SplashState.initial)
    private val sideEffect = MutableSharedFlow<SplashSideEffect>()
    private val navigation = MutableSharedFlow<BinumbersNavigation>()

    override fun observeState(): StateFlow<SplashState> = state
    override fun observeSideEffect(): Flow<SplashSideEffect> = sideEffect
    override fun observeNavigation(): Flow<BinumbersNavigation> = navigation

    @Suppress("MagicNumber")
    override fun dispatch(action: SplashAction) {
        val oldState = state.value
        when (action) {
            is SplashAction.Load -> {
                state.value = oldState.copy(progress = true)
            }
            SplashAction.Pause -> {}
            SplashAction.Resume -> {
                launch {
                    state.value = oldState.copy(progress = false)
                    navigation.emitNavigation(
                        from = Screen.Splash.fromScreen(),
                        to = Screen.Main.toScreen(),
                        inclusiveScreen = true
                    )
                }
            }
        }
    }
}
