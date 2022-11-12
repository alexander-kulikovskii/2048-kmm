package by.game.binumbers.screen.game

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import by.game.binumbers.base.BinumbersState
import by.game.binumbers.game.domain.generated.GameState
import by.game.binumbers.screenshot.test.tool.BaseScreenTest

class GameTest : BaseScreenTest(GameState::class.java) {
    override val content: @Composable (BinumbersState, WindowWidthSizeClass) -> Unit =
        { data, sizeClass ->
            GameContent(
                data as GameState,
                windowWidthSizeClass = sizeClass,
            )
        }
}
