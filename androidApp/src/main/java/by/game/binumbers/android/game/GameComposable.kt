package by.game.binumbers.android.game

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.navigation.NavGraphBuilder
import by.game.binumbers.android.extension.slideIntoLeft
import by.game.binumbers.android.extension.slideIntoRight
import by.game.binumbers.android.extension.slideOutOfLeft
import by.game.binumbers.android.extension.slideOutOfRight
import by.game.binumbers.android.getRouteLevelId
import by.game.binumbers.base.navigation.GAME_ROUTE
import by.game.binumbers.base.navigation.Router
import by.game.binumbers.base.navigation.Screen
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
internal fun NavGraphBuilder.gameComposable(
    windowSizeClass: WindowWidthSizeClass,
    router: Router,
) {
    composable(GAME_ROUTE,
        enterTransition = {
            when (initialState.destination.route) {
                Screen.Levels.route -> slideIntoLeft()
                Screen.Pause.route -> slideIntoRight()
                else -> null
            }
        },
        exitTransition = {
            when (targetState.destination.route) {
                Screen.Levels.route -> slideOutOfRight()
                Screen.Pause.route -> slideOutOfLeft()
                else -> null
            }
        }
    ) { backStackEntry ->
        GameScreen(windowSizeClass,
            backStackEntry.getRouteLevelId(),
            onNavigate = { command ->
                router.navigateWithCommand(command)
            }
        )
    }
}
