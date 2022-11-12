package by.game.binumbers.di

import by.game.binumbers.main.domain.MainInteractor
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

internal val MainModule = module {
    single {
        MainInteractor(
            interactorDispatcher = Dispatchers.Default
        )
    }
}
