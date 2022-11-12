package by.game.binumbers.di

import by.game.binumbers.undo.data.repository.GameUndoRepositoryImpl
import by.game.binumbers.undo.data.source.local.GameUndoLocalDataSource
import by.game.binumbers.undo.data.source.local.GameUndoLocalDataSourceImpl
import by.game.binumbers.undo.domain.UndoUseCasesFacade
import by.game.binumbers.undo.domain.UndoUseCasesFacadeImpl
import by.game.binumbers.undo.domain.boundary.repository.GameUndoRepository
import by.game.binumbers.undo.domain.usecase.RestoreUndoCountUseCase
import by.game.binumbers.undo.domain.usecase.RestoreUndoEnabledUseCase
import by.game.binumbers.undo.domain.usecase.SaveUndoCountUseCase
import by.game.binumbers.undo.domain.usecase.SaveUndoEnabledUseCase
import org.koin.dsl.module

internal val UndoModule = module {

    single { GameUndoLocalDataSourceImpl(keyValueStorage = get()) as GameUndoLocalDataSource }
    single { GameUndoRepositoryImpl(gameUndoLocalDataSource = get()) as GameUndoRepository }

    single {
        UndoUseCasesFacadeImpl(
            restoreUndoCountUseCase = RestoreUndoCountUseCase(gameUndoRepository = get()),
            restoreUndoEnabledUseCase = RestoreUndoEnabledUseCase(gameUndoRepository = get()),
            saveUndoCountUseCase = SaveUndoCountUseCase(gameUndoRepository = get()),
            saveUndoEnabledUseCase = SaveUndoEnabledUseCase(gameUndoRepository = get()),
        ) as UndoUseCasesFacade
    }
}
