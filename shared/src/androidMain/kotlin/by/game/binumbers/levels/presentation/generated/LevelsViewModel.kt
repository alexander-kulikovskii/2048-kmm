package by.game.binumbers.levels.presentation.generated

import androidx.lifecycle.ViewModel
import by.game.binumbers.levels.domain.LevelsInteractor
import by.game.binumbers.levels.domain.generated.LevelsStore
import by.game.binumbers.levels.domain.model.LevelsAction

class LevelsViewModel(
    val levelsInteractor: LevelsInteractor,
) : ViewModel(), LevelsStore {
    init {
        levelsInteractor.dispatch(LevelsAction.Load)
    }

    override fun observeState() = levelsInteractor.observeState()

    override fun observeSideEffect() = levelsInteractor.observeSideEffect()

    override fun observeNavigation() = levelsInteractor.observeNavigation()

    override fun dispatch(action: LevelsAction) {
        levelsInteractor.dispatch(action)
    }
}
