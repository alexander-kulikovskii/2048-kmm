package by.game.binumbers.screen.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.game.binumbers.design.system.components.logo.LogoIcon
import by.game.binumbers.design.system.theme.BinumbersTheme
import by.game.binumbers.splash.domain.generated.SplashState

@Composable
fun SplashContent(
    state: SplashState,
    windowWidthSizeClass: WindowWidthSizeClass = WindowWidthSizeClass.Compact,
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LogoIcon(modifier = Modifier.width(280.dp))
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4_XL, showSystemUi = true)
@Composable
private fun SplashContentPreview() {
    val state = SplashState(progress = false)
    BinumbersTheme(darkTheme = true, useDynamicColor = false) {
        SplashContent(state)
    }
}
