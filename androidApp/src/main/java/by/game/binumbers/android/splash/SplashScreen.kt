package by.game.binumbers.android.splash

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import by.game.binumbers.android.extension.observeAsState
import by.game.binumbers.base.BinumbersNavigation
import by.game.binumbers.screen.splash.SplashContent
import by.game.binumbers.splash.domain.model.SplashAction
import by.game.binumbers.splash.presentation.generated.SplashViewModel
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun SplashScreen(
    windowWidthSizeClass: WindowWidthSizeClass,
    viewModel: SplashViewModel = getViewModel(),
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    navigate: (BinumbersNavigation) -> Unit,
) {
    lifecycleOwner.handleLifecycle(viewModel)

    val state by viewModel.observeState().collectAsStateWithLifecycle()
    viewModel.observerNavigation { command ->
        navigate(command)
    }

    SplashContent(state, windowWidthSizeClass)
}

@Composable
private fun LifecycleOwner.handleLifecycle(viewModel: SplashViewModel) {
    this.lifecycle.observeAsState { event ->
        when (event) {
            Lifecycle.Event.ON_RESUME -> {
                viewModel.dispatch(SplashAction.Resume)
            }
            Lifecycle.Event.ON_PAUSE -> {
                viewModel.dispatch(SplashAction.Pause)
            }
            else -> {}
        }
    }
}

// TODO move this function to ksp, add deps for android.shared module
@Composable
private fun SplashViewModel.observerNavigation(navigate: (BinumbersNavigation) -> Unit) {
    LaunchedEffect(observeNavigation()) {
        observeNavigation().collect { command ->
            navigate(command)
        }
    }
}
