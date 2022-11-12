package by.game.binumbers.splash

import by.game.binumbers.splash.domain.SplashInteractor
import by.game.binumbers.utils.wrap

fun SplashInteractor.watchState() = observeState().wrap()
fun SplashInteractor.watchSideEffect() = observeSideEffect().wrap()
fun SplashInteractor.watchNavigation() = observeNavigation().wrap()
