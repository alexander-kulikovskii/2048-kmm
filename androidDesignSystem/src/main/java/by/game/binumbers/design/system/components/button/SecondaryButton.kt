package by.game.binumbers.design.system.components.button

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import by.game.binumbers.design.system.theme.BinumbersTheme
import by.game.binumbers.design.system.theme.GameTheme

@Composable
fun SecondaryButton(text: String, onClick: () -> Unit = {}) = TextButton(
    text = text,
    borderColor = GameTheme.colors.secondaryVariant,
    contentColor = GameTheme.colors.onSecondary,
    backgroundColor = GameTheme.colors.secondary,
    onClick = onClick,
)

@Composable
fun SecondaryButton(@StringRes id: Int, onClick: () -> Unit = {}) = SecondaryButton(
    text = stringResource(id = id),
    onClick = onClick,
)

@Preview
@Composable
private fun PreviewRoundedButton() {
    BinumbersTheme(darkTheme = false, useDynamicColor = false) {
        Column {
            SecondaryButton(text = "Text")
        }
    }
}
