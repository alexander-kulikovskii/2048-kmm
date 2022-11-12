package by.game.binumbers.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import by.game.binumbers.android.game.gameComposable
import by.game.binumbers.android.levels.levelsComposable
import by.game.binumbers.android.main.mainComposable
import by.game.binumbers.android.pause.pauseComposable
import by.game.binumbers.android.settings.settingsComposable
import by.game.binumbers.android.splash.splashComposable
import by.game.binumbers.android.tutorial.tutorialComposable
import by.game.binumbers.base.navigation.GAME_ROUTE_LEVEL_ID
import by.game.binumbers.base.navigation.RouterImpl
import by.game.binumbers.base.navigation.Screen
import by.game.binumbers.design.system.theme.BinumbersTheme
import by.game.binumbers.design.system.theme.GameTheme
import by.game.binumbers.extension.navigateTo
import by.game.binumbers.settings.presentation.generated.SettingsViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import org.koin.androidx.viewmodel.ext.android.viewModel

@OptIn(ExperimentalAnimationApi::class)
@ExperimentalMaterial3WindowSizeClassApi
class MainActivity : ComponentActivity() {
    private val settingsViewModel: SettingsViewModel by viewModel()

    @OptIn(ExperimentalLifecycleComposeApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state by settingsViewModel.observeState().collectAsStateWithLifecycle()
            BinumbersTheme(useDynamicColor = state.dynamicColorsEnable, darkTheme = state.darkThemeEnable) {
//                val activity = LocalContext.current as Activity
//                LaunchedEffect(activity) {
//                    activity.window.setBackgroundDrawable(BitmapDrawable)
//                }
                val windowSizeClass = calculateWindowSizeClass(this).widthSizeClass
                Box(modifier = Modifier.background(GameTheme.colors.background)) {

                    val navController = rememberAnimatedNavController()
                    val router = RouterImpl(
                        blockNavigation = { from, to, inclusiveScreen ->
                            navController.navigateTo(from, to, inclusiveScreen)
                        },
                        blockPopUp = { _, _, count ->
                            for (i in 0 until count) {
                                navController.popBackStack()
                            }
                        }
                    )

                    AnimatedNavHost(navController = navController, startDestination = Screen.Splash.route) {
                        splashComposable(windowSizeClass, router)
                        mainComposable(windowSizeClass, router)
                        levelsComposable(windowSizeClass, router)
                        gameComposable(windowSizeClass, router)
                        tutorialComposable(windowSizeClass, router)
                        pauseComposable(windowSizeClass, router)
                        settingsComposable(windowSizeClass, router)
                    }
                }
            }
        }
    }
}

internal fun NavBackStackEntry.getRouteLevelId(): String? =
    this.arguments?.getString(GAME_ROUTE_LEVEL_ID)
