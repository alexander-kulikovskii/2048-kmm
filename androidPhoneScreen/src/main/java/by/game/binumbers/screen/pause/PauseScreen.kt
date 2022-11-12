package by.game.binumbers.screen.pause

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import by.game.binumbers.android.utils.DarkPreviewWrapper
import by.game.binumbers.design.system.components.button.ResumeButton
import by.game.binumbers.design.system.components.button.SecondaryButton
import by.game.binumbers.design.system.components.button.SettingsButton
import by.game.binumbers.pause.domain.generated.PauseState
import by.game.binumbers.screen.R

@Composable
fun PauseContent(
    state: PauseState,
    windowWidthSizeClass: WindowWidthSizeClass = WindowWidthSizeClass.Compact,
    clickFacade: PauseClickFacade = PauseClickFacade(),
) {
    if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
        PauseContentPortrait(state, clickFacade)
    } else {
        PauseContentLandscape(state, clickFacade)
    }
}

@Composable
private fun PauseContentPortrait(
    state: PauseState,
    clickFacade: PauseClickFacade,
) {
    Box(
        Modifier
            .fillMaxSize()
    ) {
        SettingsButton(onClick = clickFacade.onSettingsClick)

        ResumeButton(
            modifier = Modifier.align(Alignment.TopEnd),
            onClick = clickFacade.onBackClick
        )

        Column(modifier = Modifier.align(Alignment.Center)) {
            SecondaryButton(
                id = R.string.restart_game, onClick = clickFacade.onRestartClick
            )
            SecondaryButton(
                id = R.string.back_to_levels, onClick = clickFacade.onBackToLevelsClick
            )
        }
    }
}

@Composable
private fun PauseContentLandscape(
    state: PauseState,
    clickFacade: PauseClickFacade,
) {
    Box(
        Modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier
            .align(Alignment.Center)
            .fillMaxSize(fraction = 0.5f)) {

            SettingsButton(onClick = clickFacade.onSettingsClick)

            ResumeButton(
                modifier = Modifier.align(Alignment.TopEnd),
                onClick = clickFacade.onResumeClick
            )

            Column(modifier = Modifier.align(Alignment.Center)) {
                SecondaryButton(
                    id = R.string.restart_game, onClick = clickFacade.onRestartClick
                )
                SecondaryButton(
                    id = R.string.back_to_levels, onClick = clickFacade.onBackToLevelsClick
                )
            }
        }
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
private fun PauseContentPreview() {
    val state = PauseState(progress = true)
    DarkPreviewWrapper {
        PauseContent(state, windowWidthSizeClass = WindowWidthSizeClass.Compact)
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
    val state = PauseState(progress = true)
    DarkPreviewWrapper {
        PauseContent(state, windowWidthSizeClass = WindowWidthSizeClass.Expanded)
    }
}
