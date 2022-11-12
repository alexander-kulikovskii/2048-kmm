package by.game.binumbers.screen.splash

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import by.game.binumbers.base.BinumbersState
import by.game.binumbers.screenshot.test.tool.BaseScreenTest
import by.game.binumbers.splash.domain.generated.SplashState

class SplashTest : BaseScreenTest(SplashState::class.java) {
    override val content: @Composable (BinumbersState, WindowWidthSizeClass) -> Unit =
        { data, sizeClass ->
            SplashContent(
                data as SplashState,
                windowWidthSizeClass = sizeClass
            )
        }
}
