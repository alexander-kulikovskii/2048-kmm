package by.game.binumbers.main

import by.game.binumbers.main.domain.MainInteractor
import by.game.binumbers.utils.wrap

fun MainInteractor.watchState() = observeState().wrap()
fun MainInteractor.watchSideEffect() = observeSideEffect().wrap()
fun MainInteractor.watchNavigation() = observeNavigation().wrap()
