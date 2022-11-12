package by.game.binumbers.screen.levels

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import by.game.binumbers.base.BinumbersState
import by.game.binumbers.levels.domain.generated.LevelsState
import by.game.binumbers.screenshot.test.tool.BaseScreenTest

class LevelsTest : BaseScreenTest(LevelsState::class.java) {
    override val content: @Composable (BinumbersState, WindowWidthSizeClass) -> Unit =
        { data, sizeClass ->
            LevelsContent(
                data as LevelsState,
                windowWidthSizeClass = sizeClass,
            )
        }
}
