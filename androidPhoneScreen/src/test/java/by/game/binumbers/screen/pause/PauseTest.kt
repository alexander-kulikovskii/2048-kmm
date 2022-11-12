package by.game.binumbers.screen.pause

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import by.game.binumbers.base.BinumbersState
import by.game.binumbers.pause.domain.generated.PauseState
import by.game.binumbers.screenshot.test.tool.BaseScreenTest

class PauseTest : BaseScreenTest(PauseState::class.java) {
    override val content: @Composable (BinumbersState, WindowWidthSizeClass) -> Unit =
        { data, sizeClass ->
            PauseContent(
                data as PauseState,
                windowWidthSizeClass = sizeClass
            )
        }
}
