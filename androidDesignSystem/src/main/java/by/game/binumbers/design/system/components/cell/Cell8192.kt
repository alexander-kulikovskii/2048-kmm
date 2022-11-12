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
fun Cell8192(modifier: Modifier = Modifier, enable: Boolean = true) {
    val colorAlpha = if (enable) 1f else DISABLED_CELL_ALPHA // TODO maybe remember such value
    Icon(
        makeCellFromPath(
            numberPathList = listOf(CELL_8192_PATH_1, CELL_8192_PATH_2, CELL_8192_PATH_3, CELL_8192_PATH_4),
            numberColor = GameTheme.colors.cellTextColor.copy(alpha = colorAlpha),
            backgroundColor = GameTheme.colors.cell4BackgroundColor,
            shadowColor = GameTheme.colors.cell4ShadowColor,
            centerLineColor = GameTheme.colors.cell8192CenterLineColor,
            crownPathList = listOf(CELL_8192_CROWN_1, CELL_8192_CROWN_2),
            crownColor = GameTheme.colors.logoCrownColor.copy(alpha = colorAlpha),
            crownDarkColor = GameTheme.colors.logoCrownDarkColor.copy(alpha = colorAlpha),
        ),
        contentDescription = "Cell 8192",
        tint = Color.Unspecified,
        modifier = modifier,
    )
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 8192 day mode", uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun Cell8192PreviewDayMode() {
    LightPreviewWrapper {
        Cell8192()
    }
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 8192 night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Cell8192PreviewNightMode() {
    DarkPreviewWrapper {
        Cell8192()
    }
}
