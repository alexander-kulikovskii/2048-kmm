package by.game.binumbers.android.levels

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.navigation.NavGraphBuilder
import by.game.binumbers.android.extension.slideIntoLeft
import by.game.binumbers.android.extension.slideIntoRight
import by.game.binumbers.android.extension.slideOutOfLeft
import by.game.binumbers.android.extension.slideOutOfRight
import by.game.binumbers.base.navigation.GAME_ROUTE
import by.game.binumbers.base.navigation.Router
import by.game.binumbers.base.navigation.Screen
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
internal fun NavGraphBuilder.levelsComposable(
    windowSizeClass: WindowWidthSizeClass,
    router: Router,
) {
    composable(Screen.Levels.route,
        enterTransition = {
            when (initialState.destination.route) {
                Screen.Main.route -> slideIntoLeft()
                GAME_ROUTE -> slideIntoRight()
                else -> null
            }
        },
        exitTransition = {
            when (targetState.destination.route) {
                Screen.Main.route -> slideOutOfRight()
                GAME_ROUTE -> slideOutOfLeft()
                else -> null
            }
        }
    ) {
        LevelsScreen(windowSizeClass,
            onNavigate = { command ->
                router.navigateWithCommand(command)
            }
        )
    }
}
