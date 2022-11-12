package by.game.binumbers.android.splash

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.navigation.NavGraphBuilder
import by.game.binumbers.base.navigation.Router
import by.game.binumbers.base.navigation.Screen
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
internal fun NavGraphBuilder.splashComposable(windowSizeClass: WindowWidthSizeClass, router: Router) {
    composable(Screen.Splash.route) {
        SplashScreen(windowSizeClass) { command ->
            router.navigateWithCommand(command)
        }
    }
}