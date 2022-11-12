package by.game.binumbers.screenshot.test.tool.android

import by.game.binumbers.base.BinumbersState
import by.game.binumbers.base.model.CellId
import by.game.binumbers.game.domain.generated.GameState
import by.game.binumbers.levels.domain.generated.LevelsState
import by.game.binumbers.main.domain.generated.MainState
import by.game.binumbers.pause.domain.generated.PauseState
import by.game.binumbers.splash.domain.generated.SplashState
import com.google.testing.junit.testparameterinjector.TestParameter

internal class StateWrapper(
    val state: BinumbersState,
    val useForFontScale: Boolean = false,
) {
    override fun toString(): String {
        return state.toString()
    }
}

@Suppress("MagicNumber")
internal val gameStatesList = listOf(
    StateWrapper(
        GameState(
            progress = true,
            width = 4,
            score = 1024L,
            height = 4,
            cells = (1..16).map { CellId.C_EMPTY }
        )
    ),
    StateWrapper(
        GameState(
            progress = true,
            score = 2048L,
            width = 4,
            height = 4,
            cells = (1..16).map { CellId.C_2 }
        ),
        useForFontScale = true
    ),
)

internal val levelsStatesList = listOf(
    StateWrapper(
        LevelsState(
            progress = true,
            level2048Enable = true,
            level4096Enable = false,
            level8192Enable = false,
            levelUnlimitedEnable = false,
        )
    ),
    StateWrapper(
        LevelsState(
            progress = false,
            level2048Enable = true,
            level4096Enable = true,
            level8192Enable = false,
            levelUnlimitedEnable = false,
        )
    ),
    StateWrapper(
        LevelsState(
            progress = false,
            level2048Enable = true,
            level4096Enable = true,
            level8192Enable = true,
            levelUnlimitedEnable = true,
        )
    ),
)

internal val mainStatesList =
    listOf(StateWrapper(MainState(progress = true), useForFontScale = true))

internal val splashStatesList = listOf(StateWrapper(SplashState(progress = true)))

internal val pauseStatesList =
    listOf(StateWrapper(PauseState(progress = true), useForFontScale = true))

internal object ScreenListProvider : TestParameter.TestParameterValuesProvider {
    override fun provideValues(): List<StateWrapper> {
        return splashStatesList + mainStatesList + levelsStatesList + gameStatesList + pauseStatesList
    }
}
