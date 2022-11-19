package by.game.binumbers.android.tutorial

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import by.game.binumbers.android.utils.DarkPreviewWrapper
import by.game.binumbers.base.BinumbersNavigation
import by.game.binumbers.design.system.components.button.BackButton
import by.game.binumbers.design.system.components.button.PrimaryButton
import by.game.binumbers.tutorial.domain.generated.TutorialState
import by.game.binumbers.tutorial.domain.model.TutorialAction
import by.game.binumbers.tutorial.presentation.generated.TutorialViewModel
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun TutorialScreen(
    windowWidthSizeClass: WindowWidthSizeClass,
    onNavigate: (BinumbersNavigation) -> Unit,
    viewModel: TutorialViewModel = getViewModel(),
) {
    val state by viewModel.observeState().collectAsStateWithLifecycle()
    viewModel.observerNavigation { command ->
        onNavigate(command)
    }

    TutorialContent(
        state,
        windowWidthSizeClass,
        onBackClick = { viewModel.dispatch(TutorialAction.OnClickDone) },
        onClickDone = { viewModel.dispatch(TutorialAction.OnClickDone) }
    )
}

// TODO move this function to ksp, add deps for android.shared module
@Composable
private fun TutorialViewModel.observerNavigation(onNavigate: (BinumbersNavigation) -> Unit) {
    LaunchedEffect(observeNavigation()) {
        observeNavigation().collect { command ->
            onNavigate(command)
        }
    }
}

@Composable
private fun TutorialContent(
    state: TutorialState,
    windowWidthSizeClass: WindowWidthSizeClass = WindowWidthSizeClass.Compact,
    onBackClick: () -> Unit = {},
    onClickDone: () -> Unit = {},
) {
    BackHandler(onBack = onBackClick)
    if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
        TutorialContentPortrait(
            state,
            onBackClick = onBackClick,
            onClickDone = onClickDone,
        )
    } else {
        TutorialContentLandscape(
            state,
            onBackClick = onBackClick,
            onClickDone = onClickDone,
        )
    }
}

@Composable
private fun TutorialContentPortrait(
    state: TutorialState,
    onBackClick: () -> Unit = {},
    onClickDone: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        BackButton(onClick = onBackClick)

        PrimaryButton("Tutorial", onClick = onClickDone)
    }
}

@Composable
private fun TutorialContentLandscape(
    state: TutorialState,
    onBackClick: () -> Unit = {},
    onClickDone: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        BackButton(onClick = onBackClick)

        PrimaryButton("Tutorial", onClick = onClickDone)
    }
}

@Preview(showBackground = true,
    group = "portrait",
    locale = "en",
    device = Devices.PIXEL_4_XL,
    showSystemUi = true)
@Preview(showBackground = true,
    group = "portrait",
    locale = "ru",
    device = Devices.PIXEL_4_XL,
    showSystemUi = true)
@Composable
private fun TutorialContentPreview() {
    val state = TutorialState(progress = false)
    DarkPreviewWrapper {
        TutorialContent(state, windowWidthSizeClass = WindowWidthSizeClass.Compact)
    }
}

@Preview(showBackground = true,
    group = "landscape",
    locale = "en",
    device = Devices.PIXEL_C,
    showSystemUi = true)
@Preview(showBackground = true,
    group = "landscape",
    locale = "ru",
    device = Devices.PIXEL_C,
    showSystemUi = true)
@Composable
private fun MainContentPreviewTablet() {
    val state = TutorialState(progress = false)
    DarkPreviewWrapper {
        TutorialContent(state, windowWidthSizeClass = WindowWidthSizeClass.Expanded)
    }
}
