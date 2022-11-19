package by.game.binumbers.design.system.components.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.unit.dp
import by.game.binumbers.design.system.theme.GameTheme

private const val BACKGROUND = "M84.5,84.5m74.5,-0a74.5,74.5 0,1 1,-149 -0a74.5,74.5 0,1 1,149 -0"
private const val STROKE = "M84.5,84.5m84.5,-0a84.5,84.5 0,1 1,-169 -0a84.5,84.5 0,1 1,169 -0"

@Suppress("LongParameterList")
@Composable
fun RoundedButton(
    symbolPathList: List<String>,
    contentColor: Color,
    backgroundColor: Color,
    borderColor: Color,
    modifier: Modifier = Modifier,
    contentDescription: String = "Rounded button",
    onClick: () -> Unit = {},
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .padding(GameTheme.dimensions.buttonPadding)
            .height(GameTheme.dimensions.buttonHeight)
            .width(GameTheme.dimensions.buttonHeight),
    ) {
        Icon(
            makeRoundFromPath(
                symbolPathList = symbolPathList,
                symbolColor = contentColor,
                backgroundColor = backgroundColor,
                borderColor = borderColor,
            ),
            contentDescription = contentDescription,
            tint = Color.Unspecified,
        )
    }
}

@Suppress("LongParameterList")
internal fun makeRoundFromPath(
    symbolPathList: List<String>,
    symbolColor: Color,
    backgroundColor: Color,
    borderColor: Color,
    viewportWidth: Float = 169f,
    viewportHeight: Float = 169f,
): ImageVector {
    val strokeBrushBorder = SolidColor(borderColor)
    val strokeBrushBackground = SolidColor(backgroundColor)
    val strokeBrushSymbol = SolidColor(symbolColor)

    return ImageVector.Builder(
        defaultWidth = viewportWidth.dp,
        defaultHeight = viewportHeight.dp,
        viewportWidth = viewportWidth,
        viewportHeight = viewportHeight,
    ).run {
        addPath(
            pathData = addPathNodes(STROKE),
            name = "stroke",
            fill = strokeBrushBorder,
        )
        addPath(
            pathData = addPathNodes(BACKGROUND),
            name = "background",
            fill = strokeBrushBackground,
        )
        symbolPathList.forEachIndexed { index, symbolPath ->
            addPath(
                pathData = addPathNodes(symbolPath),
                name = "symbol_$index",
                fill = strokeBrushSymbol,
                pathFillType = PathFillType.EvenOdd
            )
        }
        build()
    }
}
