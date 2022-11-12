package by.game.binumbers.tutorial.presentation.generated

import androidx.lifecycle.ViewModel
import by.game.binumbers.tutorial.domain.TutorialInteractor
import by.game.binumbers.tutorial.domain.generated.TutorialStore
import by.game.binumbers.tutorial.domain.model.TutorialAction

class TutorialViewModel(
    val tutorialInteractor: TutorialInteractor,
) : ViewModel(), TutorialStore {
    init {
        tutorialInteractor.dispatch(TutorialAction.Load)
    }

    override fun observeState() = tutorialInteractor.observeState()

    override fun observeSideEffect() = tutorialInteractor.observeSideEffect()

    override fun observeNavigation() = tutorialInteractor.observeNavigation()

    override fun dispatch(action: TutorialAction) {
        tutorialInteractor.dispatch(action)
    }
}
