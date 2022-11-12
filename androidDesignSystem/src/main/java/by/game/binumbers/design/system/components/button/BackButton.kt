package by.game.binumbers.design.system.components.button

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import by.game.binumbers.design.system.theme.BinumbersTheme
import by.game.binumbers.design.system.theme.GameTheme

private const val BACK_BUTTON_PATH = "M47.658,79.42L45.684,81.464C44.187,83.014 44.187,85.472 45.684,87.022L47.734,89.144C55.778,97.471 65.259,104.279 75.721,109.238C77.733,110.192 80.131,109.244 80.949,107.174L85.764,94.975C86.007,94.992 86.253,95 86.5,95L114.5,95C120.299,95 125,90.299 125,84.5C125,78.701 120.299,74 114.5,74L86.5,74C86.294,74 86.088,74.006 85.885,74.018L80.853,61.515C80.08,59.596 77.868,58.703 75.98,59.548C65.357,64.304 55.744,71.049 47.658,79.42Z"

@Composable
fun BackButton(onClick: () -> Unit = {}) = RoundedButton(
    symbolPathList = listOf(BACK_BUTTON_PATH),
    borderColor = GameTheme.colors.primaryVariant,
    contentColor = GameTheme.colors.onPrimary,
    backgroundColor = GameTheme.colors.primary,
    onClick = onClick,
    contentDescription = "Back button",
)

@Preview
@Composable
private fun PreviewBackButton() {
    BinumbersTheme(darkTheme = true, useDynamicColor = false) {
        Column {
            BackButton()
        }
    }
}
