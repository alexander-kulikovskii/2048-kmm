package by.game.binumbers.design.system.components.cell

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import by.game.binumbers.design.system.theme.BinumbersTheme
import by.game.binumbers.design.system.theme.GameTheme

@Composable
fun Cell2() {
    Icon(
        makeCellFromPath(
            numberPathList = listOf(CELL_2_PATH),
            numberColor = GameTheme.colors.cellTextColor,
            backgroundColor = GameTheme.colors.cell2BackgroundColor,
            shadowColor = GameTheme.colors.cell2ShadowColor,
        ),
        contentDescription = "Cell 2",
        tint = Color.Unspecified
    )
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 2 day mode", uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun Cell2PreviewDayMode() {
    BinumbersTheme(useDynamicColor = false) {
        Column {
            Cell2()
        }
    }
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 2 night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Cell2PreviewNightMode() {
    BinumbersTheme(useDynamicColor = false) {
        Column {
            Cell2()
        }
    }
}
