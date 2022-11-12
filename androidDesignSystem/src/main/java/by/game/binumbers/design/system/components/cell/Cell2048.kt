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
fun Cell2048(modifier: Modifier = Modifier, enable: Boolean = true) {
    val colorAlpha = if (enable) 1f else DISABLED_CELL_ALPHA
    Icon(
        makeCellFromPath(
            numberPathList = listOf(CELL_2048_PATH_1, CELL_2048_PATH_2, CELL_2048_PATH_3, CELL_2048_PATH_4),
            numberColor = GameTheme.colors.cellTextColor.copy(alpha = colorAlpha),
            backgroundColor = GameTheme.colors.cell2048BackgroundColor,
            shadowColor = GameTheme.colors.cell2048ShadowColor,
            centerLineColor = GameTheme.colors.cell2048CenterLineColor,
            crownPathList = listOf(CELL_2048_CROWN_1, CELL_2048_CROWN_2),
            crownColor = GameTheme.colors.logoCrownColor.copy(alpha = colorAlpha),
            crownDarkColor = GameTheme.colors.logoCrownDarkColor.copy(alpha = colorAlpha),
        ),
        contentDescription = "Cell 2048",
        tint = Color.Unspecified,
        modifier = modifier,
    )
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 2048 day mode", uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun Cell2048PreviewDayMode() {
    LightPreviewWrapper {
        Cell2048()
    }
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 2048 day mode", uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun Cell2048PreviewDayModeDisabled() {
    LightPreviewWrapper {
        Cell2048(enable = false)
    }
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 2048 night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Cell2048PreviewNightMode() {
    DarkPreviewWrapper {
        Cell2048()
    }
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 2048 night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Cell2048PreviewNightModeDisabled() {
    DarkPreviewWrapper {
        Cell2048(enable = false)
    }
}
