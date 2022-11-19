package by.game.binumbers.android.main

import MainContent
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import by.game.binumbers.base.BinumbersNavigation
import by.game.binumbers.main.domain.model.MainAction
import by.game.binumbers.main.presentation.generated.MainViewModel
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun MainScreen(
    windowWidthSizeClass: WindowWidthSizeClass,
    onNavigate: (BinumbersNavigation) -> Unit,
    viewModel: MainViewModel = getViewModel(),
) {
    val state by viewModel.observeState().collectAsStateWithLifecycle()
    viewModel.observerNavigation { command ->
        onNavigate(command)
    }

    MainContent(
        state,
        windowWidthSizeClass,
        onSettingsClick = { viewModel.dispatch(MainAction.OnClickSettings) },
        onStartClick = { viewModel.dispatch(MainAction.OnClickLevels) },
        onStatisticsClick = { viewModel.dispatch(MainAction.OnClickStatistics) },
    )
}

// TODO move this function to ksp, add deps for android.shared module
@Composable
private fun MainViewModel.observerNavigation(onNavigate: (BinumbersNavigation) -> Unit) {
    LaunchedEffect(observeNavigation()) {
        observeNavigation().collect { command ->
            onNavigate(command)
        }
    }
}
