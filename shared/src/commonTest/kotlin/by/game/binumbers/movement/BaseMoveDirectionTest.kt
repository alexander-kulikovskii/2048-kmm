package by.game.binumbers.movement

import by.game.binumbers.base.model.X
import by.game.binumbers.base.model.provideAreaByString
import by.game.binumbers.base.model.y
import by.game.binumbers.base.movement.MoveDirection
import by.game.binumbers.base.movement.MovingCell
import by.game.binumbers.base.movement.getMovingAction
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

private typealias TestMovingCellList = List<List<Pair<X, Int>>>

private fun TestMovingCellList.getMovingList(): List<MovingCell> {
    val result = mutableListOf<MovingCell>()
    this.forEachIndexed { index, list ->
        list.forEach {
            result.add(MovingCell(it.first, index.y(), it.second))
        }
    }
    return result
}

private fun MovingCell.toTestString(): String = "${x.value}_${y.value}_$delta"

private fun List<MovingCell>.toCompare(): String =
    this.map { it.toTestString() }.sorted().joinToString()

class MoveTestData(
    val inputAreaIndex: Int,
    val expectedArea: String?,
    val expectedScore: Long,
    val expectedMoveList: TestMovingCellList,
)

@Suppress("UnnecessaryAbstractClass")
abstract class BaseMoveDirectionTest(
    direction: MoveDirection,
    expectedData: List<MoveTestData>,
) : BehaviorSpec({

    expectedData.forEach { moveTestData ->
        Given("Area with index ${moveTestData.inputAreaIndex}") {
            val areaIndex = moveTestData.inputAreaIndex
            val outputArea =
                direction.getMovingAction(inputAreas[areaIndex].provideAreaByString())
            When("Make move") {
                outputArea.makeMove()
                Then("Move direction should be $direction") {
                    outputArea.moveDirection shouldBe direction
                }
                Then("Output area should be ${moveTestData.expectedArea}") {
                    outputArea.getOutputArea()
                        .toString() shouldBe moveTestData.expectedArea.toString()
                }
                Then("afterMoveIncrementScoreValue should be ${moveTestData.expectedScore}") {
                    outputArea.afterMoveIncrementScoreValue shouldBe moveTestData.expectedScore
                }
                Then(
                    "moving cell list should be ${
                    moveTestData.expectedMoveList.getMovingList().toCompare()
                    }"
                ) {
                    outputArea.movingCellList.toCompare() shouldBe
                        moveTestData.expectedMoveList.getMovingList().toCompare()
                }
            }
        }
    }
}) {
    private companion object {
        private val inputAreas = listOf(
            // 0
            """
                1 0 0 0 0
                0 1 0 0 0
                0 0 2 0 0
            """.trimIndent(),

            // 1
            """
                1 0 1 0 0
                0 1 2 0 0
                1 0 0 2 0
            """.trimIndent(),

            // 2
            """
                1 0 0 0 0
                0 1 1 0 0
                2 0 0 0 2
            """.trimIndent(),

            // 3
            """
                1 2 1 1 0
                0 2 2 0 0
                0 1 1 1 0
            """.trimIndent(),

            // 4
            """
                0 0 0 0 0
                0 0 0 0 0
                0 0 0 0 0
            """.trimIndent(),

            // 5
            """
                1 0 2 0 1
                2 2 2 2 2
                0 2 2 1 1
            """.trimIndent(),

            // 6
            """
                0 1 1 0 0
                2 0 1 1 0
                1 2 3 2 1
            """.trimIndent(),

            // 7
            """
                3 2 1 1 2
                0 2 1 0 1
                1 1 1 1 1
            """.trimIndent(),

            // 8
            """
                5 4 3 2 1
                2 0 3 0 1
                1 0 0 0 0
            """.trimIndent(),
        )
    }
}
