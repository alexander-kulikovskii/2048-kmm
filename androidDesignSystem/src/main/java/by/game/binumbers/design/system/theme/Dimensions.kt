package by.game.binumbers.design.system.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Suppress("MatchingDeclarationName")
data class GameDimensions(
    val primaryBorderPercent: Int = 50,
    val primaryBorderStroke: Dp = 4.dp,
    val buttonPadding: Dp = 8.dp,
    val buttonHeight: Dp = 64.dp,
    val buttonWidth: Dp = 200.dp,
    val scoreTextWidth: Dp = 160.dp,
    val undoTextHeight: Dp = 30.dp,
    val undoTextBorderPercent: Int = 50,
    val undoTextBorderStroke: Dp = 4.dp,
    val undoTextFontSize: TextUnit = 10.sp,
)

val LocalBinumbersDimensions = staticCompositionLocalOf { GameDimensions() }
