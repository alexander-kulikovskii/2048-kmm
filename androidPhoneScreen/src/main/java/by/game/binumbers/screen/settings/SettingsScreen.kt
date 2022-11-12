package by.game.binumbers.screen.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.game.binumbers.android.utils.DarkPreviewWrapper
import by.game.binumbers.design.system.components.CheckBoxWithLabel
import by.game.binumbers.design.system.components.button.BackButton
import by.game.binumbers.settings.domain.generated.SettingsState

private val PortraitScreenPadding = 8.dp
private val LandscapeScreenPadding = 24.dp

@Composable
fun SettingsContent(
    state: SettingsState,
    windowWidthSizeClass: WindowWidthSizeClass = WindowWidthSizeClass.Compact,
    settingsClickFacade: SettingsClickFacade = SettingsClickFacade(),
) {
    if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
        SettingsContentPortrait(
            state,
            settingsClickFacade,
        )
    } else {
        SettingsContentLandscape(
            state,
            settingsClickFacade,
        )
    }
}

@Composable
private fun SettingsContentPortrait(
    state: SettingsState,
    settingsClickFacade: SettingsClickFacade,
) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(PortraitScreenPadding)
    ) {
        BackButton(onClick = settingsClickFacade.onBackClick)
        if (state.progress) {
            CircularProgressIndicator()
        } else {
            Column(
                Modifier.align(Alignment.Center)
            ) {
                CheckBoxWithLabel(text = "Dark theme",
                    checked = state.darkThemeEnable,
                    onCheckedChange = settingsClickFacade.onDarkThemeClick)
                if (state.dynamicColorsSupported) {
                    CheckBoxWithLabel(text = "Dynamic colors",
                        checked = state.dynamicColorsEnable,
                        onCheckedChange = settingsClickFacade.onDynamicThemeClick)
                }
            }
        }
    }
}

@Composable
private fun SettingsContentLandscape(
    state: SettingsState,
    settingsClickFacade: SettingsClickFacade,
) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(LandscapeScreenPadding)
    ) {
        BackButton(onClick = settingsClickFacade.onBackClick)
        Column(
            Modifier.align(Alignment.Center)
        ) {
            Row(modifier = Modifier.padding(8.dp)) {
                Checkbox(
                    checked = state.darkThemeEnable,
                    onCheckedChange = {},
                    enabled = true,
                )
                Text(text = "Dark theme")
            }
            if (state.dynamicColorsSupported) {
                Row(modifier = Modifier.padding(8.dp)) {
                    Checkbox(
                        checked = state.darkThemeEnable,
                        onCheckedChange = {},
                        enabled = true,
                    )
                    Text(text = "Dynamic colors")
                }
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
private fun SettingsContentPreview() {
    val state = SettingsState(progress = true, true, false, false, false)
    DarkPreviewWrapper {
        SettingsContent(state, windowWidthSizeClass = WindowWidthSizeClass.Compact)
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
private fun SettingsContentPreviewTablet() {
    val state = SettingsState(progress = false, true, false, false, false)
    DarkPreviewWrapper {
        SettingsContent(state, windowWidthSizeClass = WindowWidthSizeClass.Expanded)
    }
}
