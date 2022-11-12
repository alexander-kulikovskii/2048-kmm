package by.game.binumbers.screenshot.test.tool.utils

import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_6
import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_6_PRO
import com.android.resources.ScreenOrientation

val NEXUS_10_PORT = DeviceConfig.NEXUS_10.changeScreenOrientation()
val PIXEL_C_PORT = DeviceConfig.PIXEL_C.changeScreenOrientation()

val PIXEL_7 = PIXEL_6.copy(
    released = "October 13, 2022"
)
val PIXEL_7_PRO = PIXEL_6_PRO.copy(
    released = "October 13, 2022"
)

internal fun DeviceConfig.changeScreenOrientation(): DeviceConfig {
    val screenHeight = this.screenHeight
    val screenWidth = this.screenWidth
    val orientation = this.orientation
    return this.copy(
        screenWidth = screenHeight,
        screenHeight = screenWidth,
        orientation = if (orientation == ScreenOrientation.LANDSCAPE) {
            ScreenOrientation.PORTRAIT
        } else {
            ScreenOrientation.LANDSCAPE
        }
    )
}
