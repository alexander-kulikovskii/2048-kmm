package by.game.binumbers.android.pause

import androidx.activity.compose.BackHandler
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import by.game.binumbers.base.BinumbersNavigation
import by.game.binumbers.pause.domain.model.PauseAction
import by.game.binumbers.pause.presentation.generated.PauseViewModel
import by.game.binumbers.screen.pause.PauseClickFacade
import by.game.binumbers.screen.pause.PauseContent
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun PauseScreen(
    windowWidthSizeClass: WindowWidthSizeClass,
    viewModel: PauseViewModel = getViewModel(),
    navigate: (BinumbersNavigation) -> Unit,
) {
    val state by viewModel.observeState().collectAsStateWithLifecycle()
    viewModel.observerNavigation { command ->
        navigate(command)
    }

    BackHandler(onBack = { viewModel.dispatch(PauseAction.OnClickBack) })
    val clickFacade = PauseClickFacade(
        onBackToLevelsClick = { viewModel.dispatch(PauseAction.OnClickBackToLevels) },
        onBackClick = { viewModel.dispatch(PauseAction.OnClickBack) },
        onResumeClick = { viewModel.dispatch(PauseAction.OnClickResume) },
        onRestartClick = { viewModel.dispatch(PauseAction.OnClickRestart) },
    )
    PauseContent(
        state,
        windowWidthSizeClass,
        clickFacade,
    )
}

// TODO move this function to ksp, add deps for android.shared module
@Composable
private fun PauseViewModel.observerNavigation(navigate: (BinumbersNavigation) -> Unit) {
    LaunchedEffect(observeNavigation()) {
        observeNavigation().collect { command ->
            navigate(command)
        }
    }
}
