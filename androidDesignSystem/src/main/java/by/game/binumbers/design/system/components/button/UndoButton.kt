package by.game.binumbers.design.system.components.button

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.game.binumbers.design.system.components.transitionSpec
import by.game.binumbers.design.system.theme.BinumbersTheme
import by.game.binumbers.design.system.theme.GameTheme

private const val UNDO_BUTTON_PATH =
    "M45.329,91.446L46.376,89.206C50.668,80.035 56.676,71.769 64.076,64.855C64.821,64.159 65.81,63.892 66.741,64.039C68.196,64.269 68.959,65.773 69.583,67.108L72.647,73.657C73.22,74.882 73.768,76.118 74.29,77.364C76.103,76.305 78.018,75.41 80.015,74.697C86.591,72.349 93.731,72.082 100.464,73.934C107.197,75.785 113.196,79.665 117.647,85.045C120.746,88.791 122.99,93.139 124.255,97.784C125.173,101.155 122.518,104.233 119.035,104.511C115.552,104.79 112.587,102.125 111.304,98.875C110.484,96.798 109.338,94.851 107.898,93.11C105.103,89.732 101.336,87.296 97.109,86.134C92.882,84.971 88.399,85.139 84.27,86.613C82.202,87.352 80.272,88.401 78.543,89.713C78.879,90.949 79.193,92.191 79.482,93.439L81.118,100.494C81.448,101.916 81.77,103.535 80.826,104.649C80.131,105.468 79.052,105.943 77.895,105.813C67.883,104.688 58.157,101.765 49.185,97.186L46.898,96.019C45.228,95.166 44.534,93.144 45.329,91.446Z"

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun UndoButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    undoCount: Long = 0L,
    onClick: () -> Unit = {},
) {
    Box(modifier = modifier
//        .clickable(onClick = onClick)
    ) {
        Icon(
            makeRoundFromPath(
                symbolPathList = listOf(UNDO_BUTTON_PATH),
                symbolColor = if (enabled) GameTheme.colors.onPrimary else GameTheme.colors.primaryDisabled,
                backgroundColor = GameTheme.colors.primary,
                borderColor = GameTheme.colors.primaryVariant,
            ),
            contentDescription = "Undo button",
            tint = Color.Unspecified,
            modifier = modifier
                .padding(GameTheme.dimensions.buttonPadding)
                .height(GameTheme.dimensions.buttonHeight)
                .width(GameTheme.dimensions.buttonHeight)
                .clickable(onClick = onClick),
        )
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .clip(UndoTextRoundedCornerShape())
                .height(GameTheme.dimensions.undoTextHeight)
                .width(GameTheme.dimensions.undoTextHeight)
                .padding(4.dp)
                .border(
                    GameTheme.dimensions.undoTextBorderStroke,
                    GameTheme.colors.undoTextBorderColor,
                    UndoTextRoundedCornerShape()
                )
                .padding(GameTheme.dimensions.undoTextBorderStroke)
                .background(
                    GameTheme.colors.undoTextBackgroundColor,
                    UndoTextRoundedCornerShape()
                )
        ) {
            AnimatedContent(
                modifier = Modifier.align(Alignment.Center),
                targetState = undoCount,
                transitionSpec = transitionSpec,
            ) { undoCount ->
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = undoCount.toString(),
                    fontSize = GameTheme.dimensions.undoTextFontSize,
                    color = GameTheme.colors.onPrimary,
                )
            }
        }
    }
}

@Composable
private fun UndoTextRoundedCornerShape() = RoundedCornerShape(
    topStartPercent = GameTheme.dimensions.undoTextBorderPercent,
    topEndPercent = GameTheme.dimensions.undoTextBorderPercent,
    bottomEndPercent = GameTheme.dimensions.undoTextBorderPercent,
    bottomStartPercent = GameTheme.dimensions.undoTextBorderPercent,
)

@Preview
@Composable
private fun PreviewUndoButton() {
    BinumbersTheme(darkTheme = false, useDynamicColor = false) {
        Column {
            UndoButton(undoCount = 4)
        }
    }
}

@Preview
@Composable
private fun PreviewUndoButtonDisabled() {
    BinumbersTheme(darkTheme = true, useDynamicColor = false) {
        Column {
            UndoButton(enabled = false, undoCount = 5)
        }
    }
}
