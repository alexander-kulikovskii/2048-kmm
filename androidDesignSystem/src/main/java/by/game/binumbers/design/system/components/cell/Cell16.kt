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
fun Cell16() {
    Icon(
        makeCellFromPath(
            numberPathList = listOf(CELL_16_PATH_1, CELL_16_PATH_2),
            numberColor = GameTheme.colors.cellTextColor,
            backgroundColor = GameTheme.colors.cell16BackgroundColor,
            shadowColor = GameTheme.colors.cell16ShadowColor,
        ),
        contentDescription = "Cell 16",
        tint = Color.Unspecified
    )
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 16 day mode", uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun Cell16PreviewDayMode() {
    LightPreviewWrapper {
        Cell16()
    }
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 16 night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Cell16PreviewNightMode() {
    DarkPreviewWrapper {
        Cell16()
    }
}
