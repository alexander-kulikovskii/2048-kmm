package by.game.binumbers.di

import by.game.binumbers.levels.data.repository.LevelsRepositoryImpl
import by.game.binumbers.levels.data.source.local.LevelsLocalDataSource
import by.game.binumbers.levels.data.source.local.LevelsLocalDataSourceImpl
import by.game.binumbers.levels.domain.LevelsInteractor
import by.game.binumbers.levels.domain.boundary.repository.LevelsRepository
import by.game.binumbers.levels.domain.usecase.CheckUnblockedLevelUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

internal val LevelsModule = module {

    single { LevelsLocalDataSourceImpl(keyValueStorage = get()) as LevelsLocalDataSource }
    single { LevelsRepositoryImpl(levelsLocalDataSource = get()) as LevelsRepository }
    single { CheckUnblockedLevelUseCase(levelsRepository = get()) }
    single {
        LevelsInteractor(
            interactorDispatcher = Dispatchers.Default,
            checkUnblockedLevelUseCase = get(),
        )
    }
}
