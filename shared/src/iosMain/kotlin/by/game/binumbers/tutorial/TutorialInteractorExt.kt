package by.game.binumbers.tutorial

import by.game.binumbers.tutorial.domain.TutorialInteractor
import by.game.binumbers.utils.wrap

fun TutorialInteractor.watchState() = observeState().wrap()
fun TutorialInteractor.watchSideEffect() = observeSideEffect().wrap()
fun TutorialInteractor.watchNavigation() = observeNavigation().wrap()
