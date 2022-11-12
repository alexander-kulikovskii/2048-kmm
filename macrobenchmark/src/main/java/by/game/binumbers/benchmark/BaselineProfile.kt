package by.game.binumbers.benchmark

import android.graphics.Point
import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BaselineProfile {

    @get:Rule
    val baselineRule = BaselineProfileRule()

    private lateinit var device: UiDevice

    @Before
    fun setUp() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        device = UiDevice.getInstance(instrumentation)
    }

    @Test
    fun profile() {
        baselineRule.collectBaselineProfile(
            packageName = PACKAGE_NAME,
            profileBlock = {
                startActivityAndWait()
                backWhenIdle()
            }
        )
    }

    private fun backWhenIdle() {
        device.waitForIdle()
        device.pressBack()
        device.waitForIdle()
    }

    private companion object {
        private const val PACKAGE_NAME = "by.game.binumbers"
    }
}