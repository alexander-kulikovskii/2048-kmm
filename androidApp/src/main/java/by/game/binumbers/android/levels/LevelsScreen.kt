package by.game.binumbers.android.levels

import androidx.activity.compose.BackHandler
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import by.game.binumbers.base.BinumbersNavigation
import by.game.binumbers.levels.domain.model.LevelsAction
import by.game.binumbers.levels.presentation.generated.LevelsViewModel
import by.game.binumbers.screen.levels.LevelsContent
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun LevelsScreen(
    windowWidthSizeClass: WindowWidthSizeClass,
    viewModel: LevelsViewModel = getViewModel(),
    navigate: (BinumbersNavigation) -> Unit,
) {
    val state by viewModel.observeState().collectAsStateWithLifecycle()
    viewModel.observerNavigation { command ->
        navigate(command)
    }

    BackHandler(onBack = { viewModel.dispatch(LevelsAction.OnClickBack) })
    LevelsContent(
        state,
        windowWidthSizeClass,
        onBackClick = { viewModel.dispatch(LevelsAction.OnClickBack) },
        onLevelClick = { id -> viewModel.dispatch(LevelsAction.OnClickLevel(id)) }
    )
}

// TODO move this function to ksp, add deps for android.shared module
@Composable
private fun LevelsViewModel.observerNavigation(navigate: (BinumbersNavigation) -> Unit) {
    LaunchedEffect(observeNavigation()) {
        observeNavigation().collect { command ->
            navigate(command)
        }
    }
}
