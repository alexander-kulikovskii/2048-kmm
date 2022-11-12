import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.game.binumbers.android.utils.DarkPreviewWrapper
import by.game.binumbers.design.system.components.button.PrimaryButton
import by.game.binumbers.design.system.components.button.SecondaryButton
import by.game.binumbers.design.system.components.button.SettingsButton
import by.game.binumbers.design.system.components.logo.LogoIcon
import by.game.binumbers.main.domain.generated.MainState
import by.game.binumbers.screen.R

@Composable
fun MainContent(
    state: MainState,
    windowWidthSizeClass: WindowWidthSizeClass = WindowWidthSizeClass.Compact,
    onSettingsClick: () -> Unit = {},
    onStartClick: () -> Unit = {},
    onStatisticsClick: () -> Unit = {},
) {
    if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
        MainContentPortrait(
            state,
            onSettingsClick = onSettingsClick,
            onStartClick = onStartClick,
            onStatisticsClick = onStatisticsClick,
        )
    } else {
        MainContentLandscape(
            state,
            onSettingsClick = onSettingsClick,
            onStartClick = onStartClick,
            onStatisticsClick = onStatisticsClick,
        )
    }
}

@Composable
private fun MainContentPortrait(
    state: MainState,
    onSettingsClick: () -> Unit = {},
    onStartClick: () -> Unit = {},
    onStatisticsClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f),
        ) {
            SettingsButton(onClick = onSettingsClick)
            Box(
                Modifier.align(Alignment.Center)
            ) {
                LogoIcon(
                    modifier = Modifier.width(210.dp) // just for tests
                )
            }
        }

        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Column {
                PrimaryButton(text = stringResource(id = R.string.statistics),
                    onClick = onStatisticsClick)
                SecondaryButton(text = stringResource(id = R.string.start_game),
                    onClick = onStartClick)
            }
        }
    }
}

@Composable
private fun MainContentLandscape(
    state: MainState,
    onSettingsClick: () -> Unit = {},
    onStartClick: () -> Unit = {},
    onStatisticsClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        Box(
            Modifier
                .fillMaxHeight()
                .weight(1f),
        ) {
            SettingsButton(onClick = onSettingsClick)
            Box(
                Modifier.align(Alignment.Center)
            ) {
                LogoIcon(
                    modifier = Modifier.width(210.dp) // just for tests
                )
            }
        }

        Column(
            Modifier
                .fillMaxHeight()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            PrimaryButton(text = stringResource(id = R.string.statistics),
                onClick = onStatisticsClick)
            SecondaryButton(text = stringResource(id = R.string.start_game),
                onClick = onStartClick)
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
private fun MainContentPreview() {
    val state = MainState(progress = false)
    DarkPreviewWrapper {
        MainContent(state, windowWidthSizeClass = WindowWidthSizeClass.Compact)
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
    val state = MainState(progress = false)
    DarkPreviewWrapper {
        MainContent(state, windowWidthSizeClass = WindowWidthSizeClass.Expanded)
    }
}
