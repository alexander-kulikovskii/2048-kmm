package by.game.binumbers.android.game

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
import by.game.binumbers.game.domain.model.GameAction
import by.game.binumbers.game.presentation.generated.GameViewModel
import by.game.binumbers.screen.game.GameContent
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun GameScreen(
    windowWidthSizeClass: WindowWidthSizeClass,
    levelIdAsString: String?,
    onNavigate: (BinumbersNavigation) -> Unit,
    viewModel: GameViewModel = getViewModel(),
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
) {
    lifecycleOwner.handleLifecycle(viewModel)

    val state by viewModel.observeState().collectAsStateWithLifecycle()
    viewModel.observerNavigation { command ->
        onNavigate(command)
    }
    LaunchedEffect(levelIdAsString) {
        viewModel.dispatch(GameAction.StartGame(levelIdAsString!!))
    }
    GameContent(
        state, windowWidthSizeClass,
        onBackClick = { viewModel.dispatch(GameAction.OnClickBack) },
        onMoveLeft = { viewModel.dispatch(GameAction.OnMoveLeft) },
        onMoveDown = { viewModel.dispatch(GameAction.OnMoveDown) },
        onMoveRight = { viewModel.dispatch(GameAction.OnMoveRight) },
        onMoveUp = { viewModel.dispatch(GameAction.OnMoveUp) },
        onUndoClick = { viewModel.dispatch(GameAction.OnUndoClick) },
        onPauseClick = { viewModel.dispatch(GameAction.OnPauseClick) },
    )
}

@Composable
private fun LifecycleOwner.handleLifecycle(viewModel: GameViewModel) {
    this.lifecycle.observeAsState { event ->
        when (event) {
            Lifecycle.Event.ON_RESUME -> {
                viewModel.dispatch(GameAction.Resume)
            }
            Lifecycle.Event.ON_PAUSE -> {
                viewModel.dispatch(GameAction.Pause)
            }
            Lifecycle.Event.ON_CREATE -> {
            }
            Lifecycle.Event.ON_START -> {
                viewModel.dispatch(GameAction.Start)
            }
            Lifecycle.Event.ON_STOP -> {
            }
            else -> {}
        }
    }
}

// TODO move this function to ksp, add deps for android.shared module
@Composable
private fun GameViewModel.observerNavigation(onNavigate: (BinumbersNavigation) -> Unit) {
    LaunchedEffect(observeNavigation()) {
        observeNavigation().collect { command ->
            onNavigate(command)
        }
    }
}
