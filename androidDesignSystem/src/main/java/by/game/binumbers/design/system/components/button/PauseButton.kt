package by.game.binumbers.design.system.components.button

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import by.game.binumbers.design.system.theme.BinumbersTheme
import by.game.binumbers.design.system.theme.GameTheme

private const val PAUSE_BUTTON_PATH_1 =
    "M98.583,52.813C94.694,52.813 91.541,55.965 91.541,59.854L91.541,109.146C91.541,113.035 94.694,116.187 98.583,116.187C102.472,116.187 105.625,113.035 105.625,109.146L105.625,59.854C105.625,55.965 102.472,52.813 98.583,52.813Z"
private const val PAUSE_BUTTON_PATH_2 =
    "M70.416,52.813C66.527,52.813 63.375,55.965 63.375,59.854L63.375,109.146C63.375,113.035 66.527,116.187 70.416,116.187C74.305,116.187 77.458,113.035 77.458,109.146L77.458,59.854C77.458,55.965 74.305,52.813 70.416,52.813Z"

@Composable
fun PauseButton(onClick: () -> Unit = {}) = RoundedButton(
    symbolPathList = listOf(PAUSE_BUTTON_PATH_1, PAUSE_BUTTON_PATH_2),
    contentColor = GameTheme.colors.onPrimary,
    backgroundColor = GameTheme.colors.primary,
    borderColor = GameTheme.colors.primaryVariant,
    onClick = onClick,
    contentDescription = "Pause button",
)

@Preview
@Composable
private fun PreviewPauseButton() {
    BinumbersTheme(darkTheme = true, useDynamicColor = false) {
        Column {
            PauseButton()
        }
    }
}
