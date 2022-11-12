package by.game.binumbers.pause.presentation.generated

import androidx.lifecycle.ViewModel
import by.game.binumbers.pause.domain.PauseInteractor
import by.game.binumbers.pause.domain.generated.PauseStore
import by.game.binumbers.pause.domain.model.PauseAction

class PauseViewModel(
    val pauseInteractor: PauseInteractor,
) : ViewModel(), PauseStore {
    init {
        pauseInteractor.dispatch(PauseAction.Load)
    }

    override fun observeState() = pauseInteractor.observeState()

    override fun observeSideEffect() = pauseInteractor.observeSideEffect()

    override fun observeNavigation() = pauseInteractor.observeNavigation()

    override fun dispatch(action: PauseAction) {
        pauseInteractor.dispatch(action)
    }
}
