package by.game.binumbers.di

import by.game.binumbers.tutorial.data.repository.TutorialRepositoryImpl
import by.game.binumbers.tutorial.data.source.local.TutorialLocalDataSource
import by.game.binumbers.tutorial.data.source.local.TutorialLocalDataSourceImpl
import by.game.binumbers.tutorial.domain.TutorialInteractor
import by.game.binumbers.tutorial.domain.boundary.repository.TutorialRepository
import by.game.binumbers.tutorial.domain.usecase.TutorialIsAlreadyShownUseCase
import by.game.binumbers.tutorial.domain.usecase.TutorialMarkAsShownUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

internal val TutorialModule = module {
    single { TutorialLocalDataSourceImpl(keyValueStorage = get()) as TutorialLocalDataSource }
    single { TutorialRepositoryImpl(tutorialLocalDataSource = get()) as TutorialRepository }
    single {
        TutorialIsAlreadyShownUseCase(
            tutorialRepository = get()
        )
    }
    single {
        TutorialMarkAsShownUseCase(
            tutorialRepository = get()
        )
    }
    single {
        TutorialInteractor(
            interactorDispatcher = Dispatchers.Default,
            tutorialMarkAsShownUseCase = get(),
        )
    }
}
