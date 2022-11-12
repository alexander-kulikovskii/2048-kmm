package by.game.binumbers.screenshot.test.tool.provider

import com.google.testing.junit.testparameterinjector.TestParameter

internal object LanguageProvider : TestParameter.TestParameterValuesProvider {
    override fun provideValues() = listOf(
        "en", "ru"
    )
}
