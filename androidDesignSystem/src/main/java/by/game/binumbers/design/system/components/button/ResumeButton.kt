package by.game.binumbers.design.system.components.button

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import by.game.binumbers.design.system.theme.BinumbersTheme
import by.game.binumbers.design.system.theme.GameTheme

private const val RESUME_BUTTON_PATH =
    "M78.619,111.589C89.735,107.186 100.098,101.046 109.329,93.393C113.779,89.702 113.779,82.818 109.329,79.128C100.098,71.475 89.735,65.335 78.619,60.931L77.617,60.534C71.71,58.195 65.214,62.143 64.486,68.514L64.285,70.281C63.072,80.899 63.072,91.622 64.285,102.24L64.486,104.007C65.214,110.378 71.71,114.326 77.617,111.987L78.619,111.589Z"

@Composable
fun ResumeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) = RoundedButton(
    modifier = modifier,
    symbolPathList = listOf(RESUME_BUTTON_PATH),
    borderColor = GameTheme.colors.secondaryVariant,
    contentColor = GameTheme.colors.onSecondary,
    backgroundColor = GameTheme.colors.secondary,
    onClick = onClick,
    contentDescription = "Resume button",
)

@Preview
@Composable
private fun PreviewResumeButton() {
    BinumbersTheme(darkTheme = true, useDynamicColor = false) {
        Column {
            ResumeButton()
        }
    }
}
