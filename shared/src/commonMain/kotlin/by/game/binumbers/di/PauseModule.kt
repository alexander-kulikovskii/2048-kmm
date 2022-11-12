package by.game.binumbers.di

import by.game.binumbers.pause.domain.PauseInteractor
import org.koin.dsl.module

internal val PauseModule = module {
    single {
        PauseInteractor(
            boardUseCasesFacade = get(),
        )
    }
}
