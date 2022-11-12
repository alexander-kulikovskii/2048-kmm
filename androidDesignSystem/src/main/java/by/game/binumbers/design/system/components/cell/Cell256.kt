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
fun Cell256() {
    Icon(
        makeCellFromPath(
            numberPathList = listOf(CELL_256_PATH_1, CELL_256_PATH_2, CELL_256_PATH_3),
            numberColor = GameTheme.colors.cellTextColor,
            backgroundColor = GameTheme.colors.cell256BackgroundColor,
            shadowColor = GameTheme.colors.cell256ShadowColor,
        ),
        contentDescription = "Cell 256",
        tint = Color.Unspecified
    )
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 256 day mode", uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun Cell256PreviewDayMode() {
    LightPreviewWrapper {
        Cell256()
    }
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 256 night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Cell256PreviewNightMode() {
    DarkPreviewWrapper {
        Cell256()
    }
}
