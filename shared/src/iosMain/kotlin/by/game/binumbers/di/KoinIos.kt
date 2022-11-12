package by.game.binumbers.di

import by.game.binumbers.game.domain.GameInteractor
import by.game.binumbers.levels.domain.LevelsInteractor
import by.game.binumbers.main.domain.MainInteractor
import by.game.binumbers.splash.domain.SplashInteractor
import by.game.binumbers.tutorial.domain.TutorialInteractor
import org.koin.core.KoinApplication
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.module.Module

actual val platformModules: List<Module> = emptyList()

class GameDIHelper : KoinComponent {
    val gameInteractor: GameInteractor by inject()
}

class LevelsDIHelper : KoinComponent {
    val levelsInteractor: LevelsInteractor by inject()
}

class MainDIHelper : KoinComponent {
    val mainInteractor: MainInteractor by inject()
}

class SplashDIHelper : KoinComponent {
    val splashInteractor: SplashInteractor by inject()
}

class TutorialDIHelper : KoinComponent {
    val tutorialInteractor: TutorialInteractor by inject()
}

fun initKoinIos(): KoinApplication = initKoin()
