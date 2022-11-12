package by.game.binumbers.game.presentation.generated

import androidx.lifecycle.ViewModel
import by.game.binumbers.game.domain.GameInteractor
import by.game.binumbers.game.domain.generated.GameStore
import by.game.binumbers.game.domain.model.GameAction

class GameViewModel(
    val gameInteractor: GameInteractor,
) : ViewModel(), GameStore {
    init {
        gameInteractor.dispatch(GameAction.Load)
    }

    override fun observeState() = gameInteractor.observeState()

    override fun observeSideEffect() = gameInteractor.observeSideEffect()

    override fun observeNavigation() = gameInteractor.observeNavigation()

    override fun dispatch(action: GameAction) {
        gameInteractor.dispatch(action)
    }
}
