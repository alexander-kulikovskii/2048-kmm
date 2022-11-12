package by.game.binumbers.benchmark

import androidx.benchmark.macro.BaselineProfileMode
import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@LargeTest
@RunWith(Parameterized::class)
class ExampleStartupBenchmark(private val startupMode: StartupMode) {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    private fun startup(compilationMode: CompilationMode) {
        benchmarkRule.measureRepeated(
            packageName = "by.game.binumbers",
            metrics = listOf(StartupTimingMetric()),
            iterations = 3,
            startupMode = startupMode,
            compilationMode = compilationMode
        ) {
            pressHome()
            startActivityAndWait()
//            device.findObject(By.text("Старт")).click()
//            device.waitForIdle()
        }
    }

    @Test
    fun startupNoCompilation() {
        startup(CompilationMode.None())
    }

    @Test
    fun startupBaselineProfile() {
        startup(CompilationMode.Partial(
            baselineProfileMode = BaselineProfileMode.Require
        ))
    }

    companion object {
        @Parameterized.Parameters(name = "mode={0}")
        @JvmStatic
        fun parameters(): List<Array<Any>> {
            return listOf(StartupMode.COLD, StartupMode.WARM)
                .map { arrayOf(it) }
        }
    }
}