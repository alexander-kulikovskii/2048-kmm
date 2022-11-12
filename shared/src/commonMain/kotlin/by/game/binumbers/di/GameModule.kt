package by.game.binumbers.di

import by.game.binumbers.game.domain.GameInteractor
import by.game.binumbers.game.domain.usecase.MakeMoveUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

internal val GameModule = module {

    single {
        GameInteractor(
            interactorDispatcher = Dispatchers.Default,
            boardUseCasesFacade = get(),
            undoUseCasesFacade = get(),
            scoreUseCasesFacade = get(),
            makeMoveUseCase = MakeMoveUseCase(randomizer = get()),
            tutorialIsAlreadyShownUseCase = get(),
        )
    }
}
