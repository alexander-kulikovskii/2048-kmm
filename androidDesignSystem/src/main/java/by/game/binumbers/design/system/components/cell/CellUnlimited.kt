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
fun CellUnlimited(modifier: Modifier = Modifier, enable: Boolean = true) {
    val colorAlpha = if (enable) 1f else DISABLED_CELL_ALPHA // TODO maybe remember such value
    Icon(
        makeCellFromPath(
            numberPathList = listOf(CELL_TIME_PATH_1, CELL_TIME_PATH_2),
            oddForPathStartingFrom = 1,
            numberColor = GameTheme.colors.cellTextColor.copy(alpha = colorAlpha),
            backgroundColor = GameTheme.colors.cell8BackgroundColor,
            shadowColor = GameTheme.colors.cell8ShadowColor,
            centerLineColor = GameTheme.colors.cellUnlimitedCenterLineColor,
            crownColor = GameTheme.colors.logoCrownColor.copy(alpha = colorAlpha),
            crownDarkColor = GameTheme.colors.logoCrownDarkColor.copy(alpha = colorAlpha),
        ),
        contentDescription = "Cell time",
        tint = Color.Unspecified,
        modifier = modifier,
    )
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell Unlimited day mode", uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun CellUnlimitedPreviewDayMode() {
    LightPreviewWrapper {
        CellUnlimited()
    }
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell Unlimited night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun CellUnlimitedPreviewNightMode() {
    DarkPreviewWrapper {
        CellUnlimited()
    }
}
