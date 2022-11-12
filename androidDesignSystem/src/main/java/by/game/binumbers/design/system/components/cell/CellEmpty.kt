package by.game.binumbers.design.system.components.cell

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import by.game.binumbers.android.utils.DarkPreviewWrapper
import by.game.binumbers.android.utils.LightPreviewWrapper
import by.game.binumbers.design.system.theme.GameTheme

@Composable
fun CellEmpty() {
    Icon(
        makeCellFromPath(
            numberPathList = emptyList(),
            numberColor = GameTheme.colors.cellTextColor,
            backgroundColor = GameTheme.colors.cellEmptyBackgroundColor,
            shadowColor = GameTheme.colors.cellEmptyShadowColor,
        ),
        contentDescription = "Cell empty",
        tint = Color.Unspecified
    )
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell Empty day mode", uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun CellEmptyPreviewDayMode() {
    LightPreviewWrapper {
        CellEmpty()
    }
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell Empty night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun CellEmptyPreviewNightMode() {
    DarkPreviewWrapper {
        CellEmpty()
    }
}
