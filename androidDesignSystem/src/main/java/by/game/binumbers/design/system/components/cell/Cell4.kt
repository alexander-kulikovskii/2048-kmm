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
fun Cell4() {
    Icon(
        makeCellFromPath(
            numberPathList = listOf(CELL_4_PATH),
            numberColor = GameTheme.colors.cellTextColor,
            backgroundColor = GameTheme.colors.cell4BackgroundColor,
            shadowColor = GameTheme.colors.cell4ShadowColor,
        ),
        contentDescription = "Cell 4",
        tint = Color.Unspecified
    )
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 4 day mode", uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun Cell4PreviewDayMode() {
    LightPreviewWrapper {
        Cell4()
    }
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 4 night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Cell4PreviewNightMode() {
    DarkPreviewWrapper {
        Cell4()
    }
}
