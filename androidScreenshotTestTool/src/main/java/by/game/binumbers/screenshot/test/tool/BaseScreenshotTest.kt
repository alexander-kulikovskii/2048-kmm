package by.game.binumbers.screenshot.test.tool

import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.android.resources.ScreenOrientation
import org.junit.Rule

@Suppress("UnnecessaryAbstractClass")
abstract class BaseScreenshotTest {

    @get:Rule
    internal val paparazzi = Paparazzi(
        maxPercentDifference = 0.1,
        deviceConfig = DeviceConfig.NEXUS_4.copy(
            softButtons = false,
            locale = "en",
            orientation = ScreenOrientation.PORTRAIT
        ),
    )
}
