package by.game.binumbers.design.system.components.text

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import by.game.binumbers.android.utils.DarkPreviewWrapper
import by.game.binumbers.design.system.components.transitionSpec
import by.game.binumbers.design.system.theme.GameTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ScoreText(
    score: Long,
    borderColor: Color = GameTheme.colors.primaryVariant,
    contentColor: Color = GameTheme.colors.onPrimary,
    backgroundColor: Color = GameTheme.colors.primary,
) {
    Box(
        modifier = Modifier
            .padding(vertical = GameTheme.dimensions.buttonPadding)
            .clip(ScoreTextRoundedCornerShape())
            .height(GameTheme.dimensions.buttonHeight)
            .width(GameTheme.dimensions.scoreTextWidth)
            .border(
                GameTheme.dimensions.primaryBorderStroke,
                borderColor,
                ScoreTextRoundedCornerShape()
            )
            .padding(GameTheme.dimensions.primaryBorderStroke)
            .background(
                backgroundColor,
                ScoreTextRoundedCornerShape()
            ),
        contentAlignment = Alignment.Center
    ) {
        AnimatedContent(
            targetState = score,
            transitionSpec = transitionSpec,
        ) { targetCount ->
            Text(text = "$targetCount", color = contentColor)
        }
    }
}

@Composable
private fun ScoreTextRoundedCornerShape() = RoundedCornerShape(
    topStartPercent = 0,
    topEndPercent = GameTheme.dimensions.primaryBorderPercent,
    bottomEndPercent = GameTheme.dimensions.primaryBorderPercent,
    bottomStartPercent = 0
)

@Preview
@Composable
private fun ScoreTextPreview() {
    DarkPreviewWrapper {
        ScoreText(score = 100)
    }
}
