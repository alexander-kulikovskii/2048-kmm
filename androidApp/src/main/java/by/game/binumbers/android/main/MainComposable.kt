package by.game.binumbers.android.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.navigation.NavGraphBuilder
import by.game.binumbers.android.extension.slideIntoRight
import by.game.binumbers.android.extension.slideOutOfLeft
import by.game.binumbers.base.navigation.Router
import by.game.binumbers.base.navigation.Screen
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
internal fun NavGraphBuilder.mainComposable(windowSizeClass: WindowWidthSizeClass, router: Router) {
    composable(
        Screen.Main.route,
        enterTransition = {
            when (initialState.destination.route) {
                Screen.Levels.route -> slideIntoRight()
                else -> null
            }
        },
        exitTransition = {
            slideOutOfLeft()
        }
    ) {
        MainScreen(windowSizeClass,
            onNavigate = { command ->
                router.navigateWithCommand(command)
            }
        )
    }
}
