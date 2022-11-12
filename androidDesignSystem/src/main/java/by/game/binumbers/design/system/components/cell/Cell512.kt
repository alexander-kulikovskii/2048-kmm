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
fun Cell512() {
    Icon(
        makeCellFromPath(
            numberPathList = listOf(CELL_512_PATH_1, CELL_512_PATH_2, CELL_512_PATH_3),
            numberColor = GameTheme.colors.cellTextColor,
            backgroundColor = GameTheme.colors.cell512BackgroundColor,
            shadowColor = GameTheme.colors.cell512ShadowColor,
        ),
        contentDescription = "Cell 512",
        tint = Color.Unspecified
    )
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 512 day mode", uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun Cell512PreviewDayMode() {
    LightPreviewWrapper {
        Cell512()
    }
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 512 night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Cell512PreviewNightMode() {
    DarkPreviewWrapper {
        Cell512()
    }
}
