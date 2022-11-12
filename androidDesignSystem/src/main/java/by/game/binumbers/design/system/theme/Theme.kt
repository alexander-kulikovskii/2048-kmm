package by.game.binumbers.design.system.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Suppress("MatchingDeclarationName")
object GameTheme {
    val colors: GameColors
        @Composable
        @ReadOnlyComposable
        get() = LocalBinumbersColors.current

    val dimensions: GameDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalBinumbersDimensions.current
}

@Suppress("FunctionNaming")
@Composable
fun BinumbersTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    useDynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val dynamicColor = useDynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

    val colors = when {
        dynamicColor && darkTheme -> dynamicDarkBinumbersColors()
        dynamicColor && !darkTheme -> dynamicLightBinumbersColors()
        darkTheme -> DarkColorPalette
        else -> LightColorPalette
    }

    val sysUiController = rememberSystemUiController()
    SideEffect {
        sysUiController.setSystemBarsColor(
            color = colors.background.copy(alpha = ALPHA_NEAR_OPAQUE)
        )
    }

    ProvideBinumbersColors(colors) {
        MaterialTheme(
            colors = debugColors(darkTheme),
            typography = Typography,
            shapes = Shapes,
            content = content,
        )
    }
}

@Suppress("FunctionNaming")
@Composable
fun ProvideBinumbersColors(
    colors: GameColors,
    content: @Composable () -> Unit,
) {
    val colorPalette = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colors]
        // provided, and overwrite the values set in it.
        colors.copy()
    }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalBinumbersColors provides colorPalette,
        LocalBinumbersDimensions provides GameDimensions(),
        content = content)
}

private val LocalBinumbersColors = staticCompositionLocalOf<GameColors> {
    error("No BinumbersColorPalette provided")
}

/**
 * A Material [Colors] implementation which sets all colors to [debugColor] to discourage usage of
 * [MaterialTheme.colors] in preference to [GameTheme.colors].
 */
private fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Magenta,
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)
