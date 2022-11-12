package by.game.binumbers.design.system.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import by.game.binumbers.design.system.theme.GameTheme

@Composable
fun TextButton(
    text: String,
    contentColor: Color,
    backgroundColor: Color,
    borderColor: Color,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .padding(GameTheme.dimensions.buttonPadding)
            .clip(RoundedCornerShape(GameTheme.dimensions.primaryBorderPercent))
            .clickable(onClick = onClick)
            .height(GameTheme.dimensions.buttonHeight)
            .width(GameTheme.dimensions.buttonWidth)
            .border(
                GameTheme.dimensions.primaryBorderStroke,
                borderColor,
                RoundedCornerShape(GameTheme.dimensions.primaryBorderPercent)
            )
            .padding(GameTheme.dimensions.primaryBorderStroke)
            .background(
                backgroundColor,
                RoundedCornerShape(GameTheme.dimensions.primaryBorderPercent)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = contentColor,
        )
    }
}
