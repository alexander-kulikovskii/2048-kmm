package by.game.binumbers.levels

import by.game.binumbers.levels.domain.LevelsInteractor
import by.game.binumbers.utils.wrap

fun LevelsInteractor.watchState() = observeState().wrap()
fun LevelsInteractor.watchSideEffect() = observeSideEffect().wrap()
fun LevelsInteractor.watchNavigation() = observeNavigation().wrap()
