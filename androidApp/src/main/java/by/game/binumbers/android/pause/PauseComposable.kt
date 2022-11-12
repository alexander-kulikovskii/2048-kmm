package by.game.binumbers.android.pause

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.navigation.NavGraphBuilder
import by.game.binumbers.base.navigation.Router
import by.game.binumbers.base.navigation.Screen
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
internal fun NavGraphBuilder.pauseComposable(
    windowSizeClass: WindowWidthSizeClass,
    router: Router,
) {
    composable(
        Screen.Pause.route,
    ) {
        PauseScreen(windowSizeClass) { command ->
            router.navigateWithCommand(command)
        }
    }
}
