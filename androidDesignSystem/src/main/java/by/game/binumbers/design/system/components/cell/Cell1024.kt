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
fun Cell1024() {
    Icon(
        makeCellFromPath(
            numberPathList = listOf(CELL_1024_PATH_1, CELL_1024_PATH_2, CELL_1024_PATH_3, CELL_1024_PATH_4),
            numberColor = GameTheme.colors.cellTextColor,
            backgroundColor = GameTheme.colors.cell1024BackgroundColor,
            shadowColor = GameTheme.colors.cell1024ShadowColor,
        ),
        contentDescription = "Cell 1024",
        tint = Color.Unspecified
    )
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 1024 day mode", uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun Cell1024PreviewDayMode() {
    LightPreviewWrapper {
        Cell1024()
    }
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 1024 night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Cell1024PreviewNightMode() {
    DarkPreviewWrapper {
        Cell1024()
    }
}
