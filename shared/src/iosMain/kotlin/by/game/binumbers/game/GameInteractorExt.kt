package by.game.binumbers.game

import by.game.binumbers.game.domain.GameInteractor
import by.game.binumbers.utils.wrap

fun GameInteractor.watchState() = observeState().wrap()
fun GameInteractor.watchSideEffect() = observeSideEffect().wrap()
fun GameInteractor.watchNavigation() = observeNavigation().wrap()
