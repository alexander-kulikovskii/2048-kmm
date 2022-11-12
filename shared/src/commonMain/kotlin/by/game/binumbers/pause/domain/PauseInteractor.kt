package by.game.binumbers.pause.domain

import by.game.binumbers.base.BinumbersNavigation
import by.game.binumbers.base.extension.emitPopBack
import by.game.binumbers.base.model.CellId
import by.game.binumbers.base.model.LevelId
import by.game.binumbers.base.navigation.Screen
import by.game.binumbers.base.navigation.fromScreen
import by.game.binumbers.base.navigation.toScreen
import by.game.binumbers.board.domain.BoardUseCasesFacade
import by.game.binumbers.pause.domain.generated.PauseState
import by.game.binumbers.pause.domain.generated.PauseStore
import by.game.binumbers.pause.domain.model.PauseAction
import by.game.binumbers.pause.domain.model.PauseSideEffect
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PauseInteractor(
    private val interactorDispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val boardUseCasesFacade: BoardUseCasesFacade,
) : PauseStore, CoroutineScope by CoroutineScope(interactorDispatcher) {

    private val state = MutableStateFlow(PauseState.initial)
    private val sideEffect = MutableSharedFlow<PauseSideEffect>()
    private val navigation = MutableSharedFlow<BinumbersNavigation>()

    override fun observeState(): StateFlow<PauseState> = state
    override fun observeSideEffect(): Flow<PauseSideEffect> = sideEffect
    override fun observeNavigation(): Flow<BinumbersNavigation> = navigation

    override fun dispatch(action: PauseAction) {
        when (action) {
            PauseAction.Load -> {}
            PauseAction.OnClickBack -> {
                launch {
                    backAction()
                }
            }
            PauseAction.OnClickBackToLevels -> {
                launch {
                    navigation.emitPopBack(
                        from = Screen.Pause.fromScreen(),
                        to = Screen.Levels.toScreen(),
                        removeCount = 2,
                    )
                }
            }
            PauseAction.OnClickSettings -> {}
            PauseAction.OnClickStatistics -> {}
            PauseAction.Pause -> {}
            PauseAction.Resume -> {}
            PauseAction.OnClickResume -> {
                launch {
                    backAction()
                }
            }
            PauseAction.OnClickRestart -> {
                launch {
                    val levelId = LevelId.L_2048
                    val levelSize = levelId.height * levelId.width
                    boardUseCasesFacade.saveCurrentBoard(
                        levelId,
                        (0..levelSize).map { CellId.C_EMPTY }
                    )
                    boardUseCasesFacade.savePreviousBoard(
                        levelId,
                        (0..levelSize).map { CellId.C_EMPTY }
                    )
                    backAction()
                }
            }
        }
    }

    private suspend fun backAction() {
        navigation.emitPopBack(
            from = Screen.Pause.fromScreen(),
            to = Screen.Game().toScreen(),
        )
    }
}
