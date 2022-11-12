package by.game.binumbers.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

expect val platformModules: List<Module>

@Suppress("SpreadOperator")
fun initKoin(appDeclaration: KoinAppDeclaration = {}): KoinApplication {
    return startKoin {
        appDeclaration()
        modules(
            StorageModule,
            GameModule,
            BoardModule,
            ScoreModule,
            UndoModule,
            LevelsModule,
            MainModule,
            SplashModule,
            TutorialModule,
            RandomModule,
            PauseModule,
            SettingsModule,
            *platformModules.toTypedArray(),
        )
    }
}
