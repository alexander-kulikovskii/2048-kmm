package by.game.binumbers.di

import by.game.binumbers.splash.domain.SplashInteractor
import org.koin.dsl.module

internal val SplashModule = module {
    single {
        SplashInteractor(
//            interactorDispatcher = Dispatchers.Default
        )
    }
}
