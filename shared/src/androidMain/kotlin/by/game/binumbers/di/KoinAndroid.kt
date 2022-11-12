package by.game.binumbers.di

import by.game.binumbers.game.presentation.generated.GameViewModel
import by.game.binumbers.levels.presentation.generated.LevelsViewModel
import by.game.binumbers.main.presentation.generated.MainViewModel
import by.game.binumbers.pause.presentation.generated.PauseViewModel
import by.game.binumbers.settings.data.source.platform.SettingsPlatformDataSource
import by.game.binumbers.settings.data.source.platform.SettingsPlatformDataSourceImpl
import by.game.binumbers.settings.presentation.generated.SettingsViewModel
import by.game.binumbers.splash.presentation.generated.SplashViewModel
import by.game.binumbers.tutorial.presentation.generated.TutorialViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModules: List<Module> = listOf(
    module {
        viewModel { GameViewModel(gameInteractor = get()) }
    },

    module {
        viewModel { LevelsViewModel(levelsInteractor = get()) }
    },

    module {
        viewModel { MainViewModel(mainInteractor = get()) }
    },

    module {
        viewModel { SplashViewModel(splashInteractor = get()) }
    },

    module {
        viewModel { TutorialViewModel(tutorialInteractor = get()) }
    },

    module {
        viewModel { PauseViewModel(pauseInteractor = get()) }
    },

    module {
        single { SettingsPlatformDataSourceImpl() as SettingsPlatformDataSource }
        viewModel { SettingsViewModel(settingsInteractor = get()) }
    },
)
