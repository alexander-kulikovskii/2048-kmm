package by.game.binumbers.di

import by.game.binumbers.board.data.repository.GameBoardRepositoryImpl
import by.game.binumbers.board.data.source.local.GameBoardLocalDataSource
import by.game.binumbers.board.data.source.local.GameBoardLocalDataSourceImpl
import by.game.binumbers.board.domain.BoardUseCasesFacade
import by.game.binumbers.board.domain.BoardUseCasesFacadeImpl
import by.game.binumbers.board.domain.boundary.repository.GameBoardRepository
import by.game.binumbers.board.domain.usecase.RestoreOrCreateBoardUseCase
import by.game.binumbers.board.domain.usecase.SaveBoardUseCase
import org.koin.dsl.module

internal val BoardModule = module {

    single { GameBoardLocalDataSourceImpl(keyValueStorage = get()) as GameBoardLocalDataSource }
    single { GameBoardRepositoryImpl(gameBoardLocalDataSource = get()) as GameBoardRepository }

    single {
        BoardUseCasesFacadeImpl(
            restoreOrCreateBoardUseCase = RestoreOrCreateBoardUseCase(
                gameBoardRepository = get(),
                randomizer = get()
            ),
            saveBoardUseCase = SaveBoardUseCase(gameBoardRepository = get()),
        ) as BoardUseCasesFacade
    }
}
