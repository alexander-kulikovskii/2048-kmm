package by.game.binumbers.tutorial.domain

import by.game.binumbers.base.BinumbersNavigation
import by.game.binumbers.base.extension.emitPopBack
import by.game.binumbers.base.navigation.Screen
import by.game.binumbers.base.navigation.fromScreen
import by.game.binumbers.base.navigation.toScreen
import by.game.binumbers.tutorial.domain.generated.TutorialState
import by.game.binumbers.tutorial.domain.generated.TutorialStore
import by.game.binumbers.tutorial.domain.model.TutorialAction
import by.game.binumbers.tutorial.domain.model.TutorialSideEffect
import by.game.binumbers.tutorial.domain.usecase.TutorialMarkAsShownUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TutorialInteractor(
    private val interactorDispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val tutorialMarkAsShownUseCase: TutorialMarkAsShownUseCase,
) : TutorialStore, CoroutineScope by CoroutineScope(interactorDispatcher) {

    private val state = MutableStateFlow(TutorialState.initial)
    private val sideEffect = MutableSharedFlow<TutorialSideEffect>()
    private val navigation = MutableSharedFlow<BinumbersNavigation>()

    override fun observeState(): StateFlow<TutorialState> = state
    override fun observeSideEffect(): Flow<TutorialSideEffect> = sideEffect
    override fun observeNavigation(): Flow<BinumbersNavigation> = navigation

    override fun dispatch(action: TutorialAction) {
        when (action) {
            is TutorialAction.Load -> {}
            is TutorialAction.OnClickDone -> {
                launch {
                    tutorialMarkAsShownUseCase.invoke()
                    navigation.emitPopBack(
                        from = Screen.Tutorial.fromScreen(),
                        to = Screen.Game().toScreen(),
                    )
                }
            }
        }
    }
}
