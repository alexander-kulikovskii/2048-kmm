package by.game.binumbers.levels.domain

import by.game.binumbers.base.BinumbersNavigation
import by.game.binumbers.base.extension.emitNavigation
import by.game.binumbers.base.extension.emitPopBack
import by.game.binumbers.base.model.LevelId
import by.game.binumbers.base.navigation.Screen
import by.game.binumbers.base.navigation.fromScreen
import by.game.binumbers.base.navigation.toScreen
import by.game.binumbers.levels.domain.generated.LevelsState
import by.game.binumbers.levels.domain.generated.LevelsStore
import by.game.binumbers.levels.domain.model.LevelsAction
import by.game.binumbers.levels.domain.model.LevelsSideEffect
import by.game.binumbers.levels.domain.usecase.CheckUnblockedLevelUseCase
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

class LevelsInteractor(
    private val interactorDispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val checkUnblockedLevelUseCase: CheckUnblockedLevelUseCase,
) : LevelsStore, CoroutineScope by CoroutineScope(interactorDispatcher) {

    private val state = MutableStateFlow(LevelsState.initial)
    private val sideEffect = MutableSharedFlow<LevelsSideEffect>()
    private val navigation = MutableSharedFlow<BinumbersNavigation>()

    override fun observeState(): StateFlow<LevelsState> = state
    override fun observeSideEffect(): Flow<LevelsSideEffect> = sideEffect
    override fun observeNavigation(): Flow<BinumbersNavigation> = navigation

    override fun dispatch(action: LevelsAction) {

        val oldState = state.value
        when (action) {
            is LevelsAction.Load -> {
                state.value = state.value.copy(progress = true)
                launch {
                    state.value = oldState.copy(
                        progress = false,
                        level2048Enable = true,
                        level4096Enable = checkUnblockedLevelUseCase.invoke(LevelId.L_4096),
                        level8192Enable = checkUnblockedLevelUseCase.invoke(LevelId.L_8192),
                        levelUnlimitedEnable = checkUnblockedLevelUseCase.invoke(LevelId.L_UNLIMITED),
                    )
                }
            }
            is LevelsAction.OnClickBack -> {
                launch {
                    this.coroutineContext.job.cancelChildren() // TODO ???
                    navigation.emitPopBack(
                        from = Screen.Levels.fromScreen(),
                        to = Screen.Main.toScreen(),
                    )
                }
            }
            is LevelsAction.OnClickLevel -> {
                launch {
                    navigation.emitNavigation(
                        from = Screen.Levels.fromScreen(),
                        to = Screen.Game(action.id).toScreen(),
                    )
                }
            }
        }
    }
}
