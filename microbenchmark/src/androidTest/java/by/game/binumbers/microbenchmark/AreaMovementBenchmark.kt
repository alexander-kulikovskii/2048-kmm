package by.game.binumbers.microbenchmark

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.filters.LargeTest
import by.game.binumbers.base.model.Area
import by.game.binumbers.base.model.provideAreaByString
import by.game.binumbers.base.movement.MoveDirection
import by.game.binumbers.base.movement.getMovingAction
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@LargeTest
@RunWith(Parameterized::class)
class AreaMovementBenchmark(
    private val areaString: String,
) {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun testMoveLeft() {
        makeMove(MoveDirection.MOVE_LEFT)
    }

    @Test
    fun testMoveRight() {
        makeMove(MoveDirection.MOVE_RIGHT)
    }

    @Test
    fun testMoveUp() {
        makeMove(MoveDirection.MOVE_UP)
    }

    @Test
    fun testMoveDown() {
        makeMove(MoveDirection.MOVE_DOWN)
    }

    private fun makeMove(direction: MoveDirection) {
        val area: Area = areaString.provideAreaByString()
        benchmarkRule.measureRepeated {
            direction.getMovingAction(area)
        }
    }

    internal companion object {

        @Parameterized.Parameters()
        @JvmStatic
        fun parameters(): List<Array<Any>> {
            return listOf(
                """
                    0 0 0 0 0
                    0 0 0 0 0
                    0 0 0 0 0
                """.trimIndent(),
                """
                    0 0 0 0 0
                    0 0 1 0 0
                    2 1 2 2 0
                """.trimIndent(),
                """
                    1 1 1 1 1
                    1 1 1 1 1
                    1 1 1 1 1
                """.trimIndent(),
                """
                    1 2 3 4 5
                    6 7 1 2 3
                    1 2 3 5 8
                """.trimIndent(),
                """
                    1 0 0 0 0
                    6 7 1 2 3
                    0 0 0 0 8
                """.trimIndent(),
                """
                    1 0 0 0 1
                    0 0 1 1 0
                    1 0 0 0 1
                """.trimIndent(),
                """
                    0 4 0 0 1
                    3 4 2 1 1
                    1 0 2 0 1
                """.trimIndent(),
                """
                    1 0 0 0 0
                    0 0 2 0 0
                    0 0 0 0 1
                """.trimIndent(),
            ).map { arrayOf(it) }
        }
    }
}
