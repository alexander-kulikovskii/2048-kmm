package by.game.binumbers.screen.levels

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.game.binumbers.android.utils.DarkPreviewWrapper
import by.game.binumbers.base.model.LevelId
import by.game.binumbers.design.system.components.button.BackButton
import by.game.binumbers.levels.domain.generated.LevelsState
import by.game.binumbers.screen.extension.cell2048
import by.game.binumbers.screen.extension.cell4096
import by.game.binumbers.screen.extension.cell8192
import by.game.binumbers.screen.extension.cellUnlimited

private val PortraitScreenPadding = 8.dp
private val LandscapeScreenPadding = 24.dp

@Composable
fun LevelsContent(
    state: LevelsState,
    windowWidthSizeClass: WindowWidthSizeClass = WindowWidthSizeClass.Compact,
    onBackClick: () -> Unit = {},
    onLevelClick: (id: LevelId) -> Unit = {},
) {
    if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
        LevelsContentPortrait(
            state,
            onBackClick = onBackClick,
            onLevelClick = onLevelClick,
        )
    } else {
        LevelsContentLandscape(
            state,
            onBackClick = onBackClick,
            onLevelClick = onLevelClick,
        )
    }
}

@Composable
private fun LevelsContentPortrait(
    state: LevelsState,
    onBackClick: () -> Unit = {},
    onLevelClick: (id: LevelId) -> Unit = {},
) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(PortraitScreenPadding)
    ) {
        BackButton(onClick = onBackClick)
        if (state.progress) {
            CircularProgressIndicator()
        } else {
            Column(
                Modifier.align(Alignment.Center)
            ) {
                Row() {
                    cell2048(enabled = state.level2048Enable, onLevelClick)
                    cell4096(enabled = state.level4096Enable, onLevelClick)
                }
                Row() {
                    cell8192(enabled = state.level8192Enable, onLevelClick)
                    cellUnlimited(enabled = state.levelUnlimitedEnable, onLevelClick)
                }
            }
        }
    }
}

@Composable
private fun LevelsContentLandscape(
    state: LevelsState,
    onBackClick: () -> Unit = {},
    onLevelClick: (id: LevelId) -> Unit = {},
) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(LandscapeScreenPadding)
    ) {
        BackButton(onClick = onBackClick)
        Row(
            Modifier.align(Alignment.Center)
        ) {
            cell2048(enabled = state.level2048Enable, onLevelClick, isPortrait = false)
            cell4096(enabled = state.level4096Enable, onLevelClick, isPortrait = false)
            cell8192(enabled = state.level8192Enable, onLevelClick, isPortrait = false)
            cellUnlimited(enabled = state.levelUnlimitedEnable, onLevelClick, isPortrait = false)
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
private fun LevelsContentPreview() {
    val state = LevelsState(progress = true, true, false, false, false)
    DarkPreviewWrapper {
        LevelsContent(state, windowWidthSizeClass = WindowWidthSizeClass.Compact)
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
    val state = LevelsState(progress = false, true, false, false, false)
    DarkPreviewWrapper {
        LevelsContent(state, windowWidthSizeClass = WindowWidthSizeClass.Expanded)
    }
}
