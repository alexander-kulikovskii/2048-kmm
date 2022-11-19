package by.game.binumbers.screenshot.test.tool

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import by.game.binumbers.base.BinumbersState
import by.game.binumbers.design.system.theme.BinumbersTheme
import by.game.binumbers.design.system.theme.GameTheme
import by.game.binumbers.screenshot.test.tool.android.ScreenListProvider
import by.game.binumbers.screenshot.test.tool.android.StateWrapper
import by.game.binumbers.screenshot.test.tool.provider.DynamicThemeDeviceProvider
import by.game.binumbers.screenshot.test.tool.provider.FontScaleDeviceProvider
import by.game.binumbers.screenshot.test.tool.provider.FontScaleProvider
import by.game.binumbers.screenshot.test.tool.provider.LanguageDevicePreviewProvider
import by.game.binumbers.screenshot.test.tool.provider.LanguageProvider
import by.game.binumbers.screenshot.test.tool.provider.ThemeProvider
import by.game.binumbers.screenshot.test.tool.provider.ThemeWrapper
import by.game.binumbers.screenshot.test.tool.provider.WholeScreenDeviceProvider
import by.game.binumbers.screenshot.test.tool.utils.DeviceConfigWrapper
import by.game.binumbers.screenshot.test.tool.utils.toScreenOrientation
import com.google.common.truth.TruthJUnit.assume
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(TestParameterInjector::class)
abstract class BaseScreenTest(
    private val stateClass: Class<out BinumbersState>,
) : BaseScreenshotTest() {

    abstract val content: @Composable (BinumbersState, WindowWidthSizeClass) -> Unit

    private fun StateWrapper.skipIfUnsupportedState(useOnlyForFontScale: Boolean = false) {
        assume().that(this.state).isInstanceOf(stateClass)
        if (useOnlyForFontScale) {
            assume().that(this.useForFontScale).isTrue()
        }
    }

    @TestParameter(valuesProvider = ScreenListProvider::class)
    private val data: StateWrapper? = null

    @Test
    internal fun previewWholeScreen(
        @TestParameter(valuesProvider = WholeScreenDeviceProvider::class) deviceWrapper: DeviceConfigWrapper,
    ) {
        data!!.skipIfUnsupportedState()

        paparazzi.unsafeUpdateConfig(deviceConfig = deviceWrapper.device)
        paparazzi.snapshot {
            BinumbersTheme(darkTheme = true, useDynamicColor = false) {
                Box(modifier = Modifier.background(GameTheme.colors.background)) {
                    content.invoke(data.state, deviceWrapper.toScreenOrientation())
                }
            }
        }
    }

    @Test
    internal fun previewLanguagesComponent(
        @TestParameter(valuesProvider = LanguageDevicePreviewProvider::class) deviceWrapper: DeviceConfigWrapper,
        @TestParameter(valuesProvider = LanguageProvider::class) locale: String,
    ) {
        data!!.skipIfUnsupportedState()

        paparazzi.unsafeUpdateConfig(
            deviceConfig = deviceWrapper.device.copy(
                locale = locale,
                orientation = deviceWrapper.orientation
            )
        )
        paparazzi.snapshot {
            BinumbersTheme(darkTheme = true, useDynamicColor = false) {
                data.Render(content = content, deviceWrapper = deviceWrapper)
            }
        }
    }

    @Test
    internal fun previewThemes(
        @TestParameter(valuesProvider = DynamicThemeDeviceProvider::class) deviceWrapper: DeviceConfigWrapper,
        @TestParameter(valuesProvider = ThemeProvider::class) theme: ThemeWrapper,
        @TestParameter(value = ["true", "false"]) dynamicColor: String,
    ) {
        data!!.skipIfUnsupportedState()

        paparazzi.apply {
            unsafeUpdateConfig(deviceConfig = deviceWrapper.device.copy(orientation = deviceWrapper.orientation))
            snapshot {
                BinumbersTheme(
                    darkTheme = theme.isDark(),
                    useDynamicColor = (dynamicColor == "true")
                ) {
                    data.Render(content = content, deviceWrapper = deviceWrapper)
                }
            }
        }
    }

    @Test
    internal fun previewFontScaleComponent(
        @TestParameter(valuesProvider = FontScaleDeviceProvider::class) deviceWrapper: DeviceConfigWrapper,
        @TestParameter(valuesProvider = FontScaleProvider::class) fontScale: Float,
        @TestParameter(valuesProvider = LanguageProvider::class) locale: String,
    ) {
        data!!.skipIfUnsupportedState(useOnlyForFontScale = true)

        paparazzi.unsafeUpdateConfig(
            deviceConfig = deviceWrapper.device.copy(
                fontScale = fontScale,
                locale = locale,
                orientation = deviceWrapper.orientation
            )
        )
        paparazzi.snapshot {
            BinumbersTheme(darkTheme = true, useDynamicColor = false) {
                data.Render(content = content, deviceWrapper = deviceWrapper)
            }
        }
    }

    @Composable
    private fun StateWrapper.Render(
        content: @Composable (BinumbersState, WindowWidthSizeClass) -> Unit,
        deviceWrapper: DeviceConfigWrapper,
    ) {
        val data = this
        Box(modifier = Modifier.background(GameTheme.colors.background)) {
            content.invoke(data.state, deviceWrapper.toScreenOrientation())
        }
    }
}
