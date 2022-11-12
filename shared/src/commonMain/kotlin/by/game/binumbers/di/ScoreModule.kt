package by.game.binumbers.di

import by.game.binumbers.score.data.repository.ScoreRepositoryImpl
import by.game.binumbers.score.data.source.local.ScoreLocalDataSource
import by.game.binumbers.score.data.source.local.ScoreLocalDataSourceImpl
import by.game.binumbers.score.domain.ScoreUseCasesFacade
import by.game.binumbers.score.domain.ScoreUseCasesFacadeImpl
import by.game.binumbers.score.domain.boundary.repository.ScoreRepository
import by.game.binumbers.score.domain.usecase.RestoreScoreUseCase
import by.game.binumbers.score.domain.usecase.SaveScoreUseCase
import org.koin.dsl.module

internal val ScoreModule = module {

    single { ScoreLocalDataSourceImpl(keyValueStorage = get()) as ScoreLocalDataSource }
    single { ScoreRepositoryImpl(scoreLocalDataSource = get()) as ScoreRepository }

    single {
        ScoreUseCasesFacadeImpl(
            restoreScoreUseCase = RestoreScoreUseCase(scoreRepository = get()),
            saveScoreUseCase = SaveScoreUseCase(scoreRepository = get()),
        ) as ScoreUseCasesFacade
    }
}
