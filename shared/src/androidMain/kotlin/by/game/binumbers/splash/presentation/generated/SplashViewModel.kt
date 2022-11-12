package by.game.binumbers.splash.presentation.generated

import androidx.lifecycle.ViewModel
import by.game.binumbers.splash.domain.SplashInteractor
import by.game.binumbers.splash.domain.generated.SplashStore
import by.game.binumbers.splash.domain.model.SplashAction

class SplashViewModel(
    val splashInteractor: SplashInteractor,
) : ViewModel(), SplashStore {
    init {
        splashInteractor.dispatch(SplashAction.Load)
    }

    override fun observeState() = splashInteractor.observeState()

    override fun observeSideEffect() = splashInteractor.observeSideEffect()

    override fun observeNavigation() = splashInteractor.observeNavigation()

    override fun dispatch(action: SplashAction) {
        splashInteractor.dispatch(action)
    }
}
