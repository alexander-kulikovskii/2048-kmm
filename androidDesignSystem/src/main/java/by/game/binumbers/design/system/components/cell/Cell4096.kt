package by.game.binumbers.design.system.components.cell

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import by.game.binumbers.android.utils.DarkPreviewWrapper
import by.game.binumbers.android.utils.LightPreviewWrapper
import by.game.binumbers.design.system.theme.GameTheme

@Composable
fun Cell4096(modifier: Modifier = Modifier, enable: Boolean = true) {
    val colorAlpha = if (enable) 1f else DISABLED_CELL_ALPHA // TODO maybe remember such value
    Icon(
        makeCellFromPath(
            numberPathList = listOf(CELL_4096_PATH_1, CELL_4096_PATH_2, CELL_4096_PATH_3, CELL_4096_PATH_4),
            numberColor = GameTheme.colors.cellTextColor.copy(alpha = colorAlpha),
            backgroundColor = GameTheme.colors.cell2BackgroundColor,
            shadowColor = GameTheme.colors.cell2ShadowColor,
            centerLineColor = GameTheme.colors.cell4096CenterLineColor,
            crownPathList = listOf(CELL_4096_CROWN_1, CELL_4096_CROWN_2),
            crownColor = GameTheme.colors.logoCrownColor.copy(alpha = colorAlpha),
            crownDarkColor = GameTheme.colors.logoCrownDarkColor.copy(alpha = colorAlpha),
        ),
        contentDescription = "Cell 4096",
        tint = Color.Unspecified,
        modifier = modifier,
    )
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 4096 day mode", uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun Cell4096PreviewDayMode() {
    LightPreviewWrapper {
        Cell4096()
    }
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 4096 night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Cell4096PreviewNightMode() {
    DarkPreviewWrapper {
        Cell4096()
    }
}
