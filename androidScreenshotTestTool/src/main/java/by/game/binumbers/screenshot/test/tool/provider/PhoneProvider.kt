package by.game.binumbers.screenshot.test.tool.provider

import app.cash.paparazzi.DeviceConfig
import by.game.binumbers.screenshot.test.tool.utils.DeviceConfigWrapper
import by.game.binumbers.screenshot.test.tool.utils.NEXUS_10_PORT
import by.game.binumbers.screenshot.test.tool.utils.PIXEL_7
import by.game.binumbers.screenshot.test.tool.utils.PIXEL_7_PRO
import by.game.binumbers.screenshot.test.tool.utils.PIXEL_C_PORT
import by.game.binumbers.screenshot.test.tool.utils.duplicateWithChangedOrientation
import com.android.resources.ScreenOrientation
import com.google.testing.junit.testparameterinjector.TestParameter

internal object ComponentsDeviceProvider : TestParameter.TestParameterValuesProvider {
    override fun provideValues() = listOf(
        DeviceConfigWrapper(DeviceConfig.NEXUS_4),
    )
}

internal object DynamicThemeDeviceProvider : TestParameter.TestParameterValuesProvider {
    override fun provideValues() = listOf(
        DeviceConfigWrapper(DeviceConfig.NEXUS_4),
    )
}

internal object FontScaleDeviceProvider : TestParameter.TestParameterValuesProvider {
    override fun provideValues() = listOf(
        DeviceConfigWrapper(DeviceConfig.NEXUS_4),
        DeviceConfigWrapper(DeviceConfig.PIXEL_C, ScreenOrientation.LANDSCAPE),
    )
}

internal object LanguageDevicePreviewProvider : TestParameter.TestParameterValuesProvider {
    override fun provideValues() = listOf(
        DeviceConfigWrapper(DeviceConfig.NEXUS_4),
        DeviceConfigWrapper(DeviceConfig.PIXEL_C, ScreenOrientation.LANDSCAPE),
    )
}

internal object WholeScreenDeviceProvider : TestParameter.TestParameterValuesProvider {
    override fun provideValues(): List<DeviceConfigWrapper> = listOf(
        DeviceConfigWrapper(DeviceConfig.NEXUS_4),
        DeviceConfigWrapper(DeviceConfig.NEXUS_5),
        DeviceConfigWrapper(DeviceConfig.PIXEL),
        DeviceConfigWrapper(DeviceConfig.PIXEL_XL),
        DeviceConfigWrapper(DeviceConfig.PIXEL_2),
        DeviceConfigWrapper(DeviceConfig.PIXEL_2_XL),
        DeviceConfigWrapper(DeviceConfig.PIXEL_3),
        DeviceConfigWrapper(DeviceConfig.PIXEL_3_XL),
        DeviceConfigWrapper(DeviceConfig.PIXEL_3A),
        DeviceConfigWrapper(DeviceConfig.PIXEL_3A_XL),
        DeviceConfigWrapper(DeviceConfig.PIXEL_4),
        DeviceConfigWrapper(DeviceConfig.PIXEL_4_XL),
        DeviceConfigWrapper(DeviceConfig.PIXEL_5),
        DeviceConfigWrapper(DeviceConfig.PIXEL_6),
        DeviceConfigWrapper(DeviceConfig.PIXEL_6_PRO),
        DeviceConfigWrapper(PIXEL_7),
        DeviceConfigWrapper(PIXEL_7_PRO),

        // Tablets
        DeviceConfigWrapper(DeviceConfig.NEXUS_7),
        DeviceConfigWrapper(DeviceConfig.NEXUS_7_2012),
        DeviceConfigWrapper(NEXUS_10_PORT),
        DeviceConfigWrapper(PIXEL_C_PORT),
    ).duplicateWithChangedOrientation()
}
