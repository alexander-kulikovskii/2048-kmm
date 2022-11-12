package by.game.binumbers.screenshot.test.tool.provider

import com.google.testing.junit.testparameterinjector.TestParameter

internal object ThemeProvider : TestParameter.TestParameterValuesProvider {
    override fun provideValues() = listOf(
        ThemeWrapper("light"),
        ThemeWrapper("dark"),
    )
}

internal class ThemeWrapper(private val name: String) {
    fun isDark() = name == "dark"

    override fun toString(): String {
        return name
    }
}
