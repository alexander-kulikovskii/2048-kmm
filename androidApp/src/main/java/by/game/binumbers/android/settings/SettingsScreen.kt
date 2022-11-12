package by.game.binumbers.android.settings

import androidx.activity.compose.BackHandler
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import by.game.binumbers.base.BinumbersNavigation
import by.game.binumbers.screen.settings.SettingsClickFacade
import by.game.binumbers.screen.settings.SettingsContent
import by.game.binumbers.settings.domain.model.SettingsAction
import by.game.binumbers.settings.presentation.generated.SettingsViewModel
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun SettingsScreen(
    windowWidthSizeClass: WindowWidthSizeClass,
    viewModel: SettingsViewModel = getViewModel(),
    navigate: (BinumbersNavigation) -> Unit,
) {
    val state by viewModel.observeState().collectAsStateWithLifecycle()
    viewModel.observerNavigation { command ->
        navigate(command)
    }

    BackHandler(onBack = { viewModel.dispatch(SettingsAction.OnClickBack) })
    SettingsContent(
        state,
        windowWidthSizeClass,
        settingsClickFacade = SettingsClickFacade(
            onBackClick = { viewModel.dispatch(SettingsAction.OnClickBack) },
            onDarkThemeClick = { viewModel.dispatch(SettingsAction.OnDarkThemeClick) },
            onDynamicThemeClick = { viewModel.dispatch(SettingsAction.OnDynamicColorsClick) }
        ),
    )
}

// TODO move this function to ksp, add deps for android.shared module
@Composable
private fun SettingsViewModel.observerNavigation(navigate: (BinumbersNavigation) -> Unit) {
    LaunchedEffect(observeNavigation()) {
        observeNavigation().collect { command ->
            navigate(command)
        }
    }
}
