package by.game.binumbers.android.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import by.game.binumbers.design.system.theme.BinumbersTheme
import by.game.binumbers.design.system.theme.GameTheme

@Suppress("FunctionNaming")
@Composable
private fun PreviewWrapper(darkTheme: Boolean, content: @Composable () -> Unit) {
    BinumbersTheme(darkTheme = darkTheme, useDynamicColor = false) {
        Box(Modifier
            .fillMaxSize()
            .background(GameTheme.colors.background)
        ) {
            content.invoke()
        }
    }
}

@Suppress("FunctionNaming")
@Composable
fun DarkPreviewWrapper(content: @Composable () -> Unit) =
    PreviewWrapper(darkTheme = true, content = content)

@Suppress("FunctionNaming")
@Composable
fun LightPreviewWrapper(content: @Composable () -> Unit) =
    PreviewWrapper(darkTheme = false, content = content)
