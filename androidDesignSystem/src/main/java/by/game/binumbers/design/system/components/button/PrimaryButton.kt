package by.game.binumbers.design.system.components.button

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import by.game.binumbers.design.system.theme.BinumbersTheme
import by.game.binumbers.design.system.theme.GameTheme

@Composable
fun PrimaryButton(text: String, onClick: () -> Unit = {}) = TextButton(
    text = text,
    borderColor = GameTheme.colors.primaryVariant,
    contentColor = GameTheme.colors.onPrimary,
    backgroundColor = GameTheme.colors.primary,
    onClick = onClick,
)

@Composable
fun PrimaryButton(@StringRes id: Int, onClick: () -> Unit = {}) = PrimaryButton(
    text = stringResource(id = id),
    onClick = onClick,
)

@Preview
@Composable
private fun PreviewPrimaryButton() {
    BinumbersTheme {
        Column {
            PrimaryButton(text = "Text")
        }
    }
}
