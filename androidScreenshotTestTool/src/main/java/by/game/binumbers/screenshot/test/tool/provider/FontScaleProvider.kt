package by.game.binumbers.screenshot.test.tool.provider

import com.google.testing.junit.testparameterinjector.TestParameter

internal object FontScaleProvider : TestParameter.TestParameterValuesProvider {
    override fun provideValues() = listOf(
        0.85f, 1f, 1.15f, 1.30f
    )
}
