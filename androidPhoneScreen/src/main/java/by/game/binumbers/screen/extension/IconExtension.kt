package by.game.binumbers.screen.extension

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import by.game.binumbers.base.model.LevelId
import by.game.binumbers.design.system.components.cell.Cell2048
import by.game.binumbers.design.system.components.cell.Cell4096
import by.game.binumbers.design.system.components.cell.Cell8192
import by.game.binumbers.design.system.components.cell.CellUnlimited

private val PortraitItemPadding = 8.dp
private val PortraitItemWidth = 100.dp

private val LandscapeItemPadding = 16.dp
private val LandscapeItemWidth = 100.dp

@Composable
internal fun cell2048(
    enabled: Boolean,
    onLevelClick: (id: LevelId) -> Unit = {},
    isPortrait: Boolean = true,
) {
    cell(LevelId.L_2048, enabled, { onLevelClick(LevelId.L_2048) }, isPortrait)
}

@Composable
internal fun cell4096(
    enabled: Boolean,
    onLevelClick: (id: LevelId) -> Unit = {},
    isPortrait: Boolean = true,
) {
    cell(LevelId.L_4096, enabled, { onLevelClick(LevelId.L_4096) }, isPortrait)
}

@Composable
internal fun cell8192(
    enabled: Boolean,
    onLevelClick: (id: LevelId) -> Unit = {},
    isPortrait: Boolean = true,
) {
    cell(LevelId.L_8192, enabled, { onLevelClick(LevelId.L_8192) }, isPortrait)
}

@Composable
internal fun cellUnlimited(
    enabled: Boolean,
    onLevelClick: (id: LevelId) -> Unit = {},
    isPortrait: Boolean = true,
) {
    cell(LevelId.L_UNLIMITED, enabled, { onLevelClick(LevelId.L_UNLIMITED) }, isPortrait)
}

@Composable
private fun cell(
    levelId: LevelId,
    enabled: Boolean,
    onLevelClick: () -> Unit = {},
    isPortrait: Boolean = true,
) {
    val modifier = Modifier
        .padding(if (isPortrait) PortraitItemPadding else LandscapeItemPadding)
        .clickable(enabled = enabled) {
            onLevelClick()
        }
        .width(if (isPortrait) PortraitItemWidth else LandscapeItemWidth)
    when (levelId) {
        LevelId.L_2048 -> Cell2048(modifier = modifier, enable = enabled)
        LevelId.L_4096 -> Cell4096(modifier = modifier, enable = enabled)
        LevelId.L_8192 -> Cell8192(modifier = modifier, enable = enabled)
        LevelId.L_UNLIMITED -> CellUnlimited(modifier = modifier, enable = enabled)
        else -> throw UnsupportedOperationException("Unsupported icon")
    }
}
