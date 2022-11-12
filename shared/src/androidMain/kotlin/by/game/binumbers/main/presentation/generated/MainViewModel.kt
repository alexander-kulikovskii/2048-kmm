package by.game.binumbers.main.presentation.generated

import androidx.lifecycle.ViewModel
import by.game.binumbers.main.domain.MainInteractor
import by.game.binumbers.main.domain.generated.MainStore
import by.game.binumbers.main.domain.model.MainAction

class MainViewModel(
    val mainInteractor: MainInteractor,
) : ViewModel(), MainStore {
    init {
        mainInteractor.dispatch(MainAction.Load)
    }

    override fun observeState() = mainInteractor.observeState()

    override fun observeSideEffect() = mainInteractor.observeSideEffect()

    override fun observeNavigation() = mainInteractor.observeNavigation()

    override fun dispatch(action: MainAction) {
        mainInteractor.dispatch(action)
    }
}
