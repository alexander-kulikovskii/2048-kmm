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
fun Cell8() {
    Icon(
        makeCellFromPath(
            numberPathList = listOf(CELL_8_PATH),
            numberColor = GameTheme.colors.cellTextColor,
            backgroundColor = GameTheme.colors.cell8BackgroundColor,
            shadowColor = GameTheme.colors.cell8ShadowColor,
        ),
        contentDescription = "Cell 8",
        tint = Color.Unspecified
    )
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 8 day mode", uiMode = UI_MODE_NIGHT_NO)
@Composable
private fun Cell8PreviewDayMode() {
    LightPreviewWrapper {
        Cell8()
    }
}

@Suppress("FunctionNaming", "UnusedPrivateMember")
@Preview(name = "Cell 8 night mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun Cell8PreviewNightMode() {
    DarkPreviewWrapper {
        Cell8()
    }
}
