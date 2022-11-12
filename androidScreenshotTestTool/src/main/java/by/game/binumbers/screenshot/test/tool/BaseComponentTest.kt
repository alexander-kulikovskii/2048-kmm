package by.game.binumbers.screenshot.test.tool

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import by.game.binumbers.design.system.theme.BinumbersTheme
import by.game.binumbers.design.system.theme.GameTheme
import by.game.binumbers.screenshot.test.tool.provider.ComponentsDeviceProvider
import by.game.binumbers.screenshot.test.tool.provider.ThemeProvider
import by.game.binumbers.screenshot.test.tool.provider.ThemeWrapper
import by.game.binumbers.screenshot.test.tool.utils.DeviceConfigWrapper
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(TestParameterInjector::class)
abstract class BaseComponentTest : BaseScreenshotTest() {

    abstract val content: @Composable () -> Unit

    @Test
    internal fun previewComponent(
        @TestParameter(valuesProvider = ComponentsDeviceProvider::class) deviceWrapper: DeviceConfigWrapper,
        @TestParameter(valuesProvider = ThemeProvider::class) theme: ThemeWrapper,
    ) {
        paparazzi.apply {
            unsafeUpdateConfig(deviceConfig = deviceWrapper.device.copy(orientation = deviceWrapper.orientation))
            snapshot {
                BinumbersTheme(darkTheme = theme.isDark(), useDynamicColor = false) {
                    Column(modifier = Modifier.background(GameTheme.colors.background)) {
                        content.invoke()
                    }
                }
            }
        }
    }
}
