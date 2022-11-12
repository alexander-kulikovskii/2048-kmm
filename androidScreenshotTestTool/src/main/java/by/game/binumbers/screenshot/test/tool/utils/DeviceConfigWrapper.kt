package by.game.binumbers.screenshot.test.tool.utils

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import app.cash.paparazzi.DeviceConfig
import com.android.resources.ScreenOrientation

data class DeviceConfigWrapper(
    val device: DeviceConfig,
    val orientation: ScreenOrientation = ScreenOrientation.PORTRAIT,
) {
    override fun toString(): String {
        return "${device.screenWidth}_${device.screenHeight}_${orientation.name}"
    }
}

internal fun DeviceConfigWrapper.toScreenOrientation(): WindowWidthSizeClass =
    if (this.orientation == ScreenOrientation.PORTRAIT) {
        WindowWidthSizeClass.Compact
    } else {
        WindowWidthSizeClass.Expanded
    }

internal fun List<DeviceConfigWrapper>.duplicateWithChangedOrientation(): List<DeviceConfigWrapper> {
    return this + this.map { it.changeScreenOrientation() }
}

internal fun DeviceConfigWrapper.changeScreenOrientation(): DeviceConfigWrapper {
    val orientation =
        if (this.orientation == ScreenOrientation.LANDSCAPE) ScreenOrientation.PORTRAIT else ScreenOrientation.LANDSCAPE
    return this.copy(device = this.device.changeScreenOrientation(), orientation = orientation)
}
