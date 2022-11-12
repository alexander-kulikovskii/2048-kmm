package by.game.binumbers.screen.main

import MainContent
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import by.game.binumbers.base.BinumbersState
import by.game.binumbers.main.domain.generated.MainState
import by.game.binumbers.screenshot.test.tool.BaseScreenTest

class MainTest : BaseScreenTest(MainState::class.java) {
    override val content: @Composable (BinumbersState, WindowWidthSizeClass) -> Unit =
        { data, sizeClass ->
            MainContent(
                data as MainState,
                windowWidthSizeClass = sizeClass,
            )
        }
}
