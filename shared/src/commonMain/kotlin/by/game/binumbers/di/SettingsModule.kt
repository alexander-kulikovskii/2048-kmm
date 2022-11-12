package by.game.binumbers.di

import by.game.binumbers.settings.data.repository.SettingsRepositoryImpl
import by.game.binumbers.settings.data.source.local.SettingsLocalDataSource
import by.game.binumbers.settings.data.source.local.SettingsLocalDataSourceImpl
import by.game.binumbers.settings.domain.SettingsInteractor
import by.game.binumbers.settings.domain.SettingsUseCasesFacade
import by.game.binumbers.settings.domain.SettingsUseCasesFacadeImpl
import by.game.binumbers.settings.domain.boundary.repository.SettingsRepository
import by.game.binumbers.settings.domain.usecase.RestoreDarkThemeUseCase
import by.game.binumbers.settings.domain.usecase.RestoreDynamicColorsIsSupportedUseCase
import by.game.binumbers.settings.domain.usecase.RestoreDynamicColorsUseCase
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

internal val SettingsModule = module {

    single { SettingsLocalDataSourceImpl(keyValueStorage = get()) as SettingsLocalDataSource }
    single {
        SettingsRepositoryImpl(
            settingsLocalDataSource = get(),
            settingsPlatformDataSource = get(), // get from platform specific
        ) as SettingsRepository
    }
    single { RestoreDynamicColorsIsSupportedUseCase(settingsRepository = get()) }
    single { RestoreDynamicColorsUseCase(settingsRepository = get()) }
    single { RestoreDarkThemeUseCase(settingsRepository = get()) }

    single {
        SettingsUseCasesFacadeImpl(
            restoreDarkThemeUseCase = get(),
            restoreDynamicColorsIsSupportedUseCase = get(),
            restoreDynamicColorsUseCase = get(),
        ) as SettingsUseCasesFacade
    }
    single {
        SettingsInteractor(
            interactorDispatcher = Dispatchers.Default,
            settingsUseCasesFacade = get(),
        )
    }
}
