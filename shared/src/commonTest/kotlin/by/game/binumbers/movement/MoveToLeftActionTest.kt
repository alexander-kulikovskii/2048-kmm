package by.game.binumbers.movement

import by.game.binumbers.base.model.x
import by.game.binumbers.base.movement.MoveDirection

class MoveToLeftActionTest : BaseMoveDirectionTest(
    direction = MoveDirection.MOVE_LEFT,
    expectedData = listOf(
        MoveTestData(
            inputAreaIndex = 0,
            expectedArea =
            """
                1 0 0 0 0
                1 0 0 0 0
                2 0 0 0 0
            """.trimIndent(),
            expectedScore = 0L,
            expectedMoveList = listOf(
                listOf(
                    0.x() to 0
                ),
                listOf(
                    1.x() to -1
                ),
                listOf(
                    2.x() to -2
                ),
            ),
        ),

        MoveTestData(
            inputAreaIndex = 1,
            expectedArea =
            """
                2 0 0 0 0
                1 2 0 0 0
                1 2 0 0 0
            """.trimIndent(),
            expectedScore = 4L,
            expectedMoveList = listOf(
                listOf(
                    2.x() to -2,
                    0.x() to 0
                ),
                listOf(
                    2.x() to -1,
                    1.x() to -1,
                ),
                listOf(
                    3.x() to -2,
                    0.x() to 0
                ),
            ),
        ),

        MoveTestData(
            inputAreaIndex = 2,
            expectedArea =
            """
                1 0 0 0 0
                2 0 0 0 0
                3 0 0 0 0
            """.trimIndent(),
            expectedScore = 12L,
            expectedMoveList = listOf(
                listOf(
                    0.x() to 0
                ),
                listOf(
                    2.x() to -2,
                    1.x() to -1,
                ),
                listOf(
                    4.x() to -4,
                    0.x() to 0
                ),
            ),
        ),

        MoveTestData(
            inputAreaIndex = 3,
            expectedArea =
            """
                1 2 2 0 0
                3 0 0 0 0
                2 1 0 0 0
            """.trimIndent(),
            expectedScore = 16L,
            expectedMoveList = listOf(
                listOf(
                    3.x() to -1,
                    2.x() to 0,
                    1.x() to 0,
                    0.x() to 0,
                ),
                listOf(
                    2.x() to -2,
                    1.x() to -1,
                ),
                listOf(
                    3.x() to -2,
                    2.x() to -2,
                    1.x() to -1,
                ),
            ),
        ),

        MoveTestData(
            inputAreaIndex = 4,
            expectedArea =
            """
                0 0 0 0 0
                0 0 0 0 0
                0 0 0 0 0
            """.trimIndent(),
            expectedScore = 0L,
            expectedMoveList = listOf(),
        ),

        MoveTestData(
            inputAreaIndex = 5,
            expectedArea =
            """
                1 2 1 0 0
                3 3 2 0 0
                3 2 0 0 0
            """.trimIndent(),
            expectedScore = 28L,
            expectedMoveList = listOf(
                listOf(
                    4.x() to -2,
                    2.x() to -1,
                    0.x() to 0,
                ),
                listOf(
                    4.x() to -2,
                    3.x() to -2,
                    2.x() to -1,
                    1.x() to -1,
                    0.x() to 0,
                ),
                listOf(
                    4.x() to -3,
                    3.x() to -2,
                    2.x() to -2,
                    1.x() to -1,
                ),
            ),
        ),

        MoveTestData(
            inputAreaIndex = 6,
            expectedArea =
            """
                2 0 0 0 0
                2 2 0 0 0
                1 2 3 2 1
            """.trimIndent(),
            expectedScore = 8L,
            expectedMoveList = listOf(
                listOf(
                    2.x() to -2,
                    1.x() to -1,
                ),
                listOf(
                    3.x() to -2,
                    2.x() to -1,
                    0.x() to 0,
                ),
                listOf(
                    4.x() to 0,
                    3.x() to 0,
                    2.x() to 0,
                    1.x() to 0,
                    0.x() to 0,
                ),
            ),
        ),

        MoveTestData(
            inputAreaIndex = 7,
            expectedArea =
            """
                3 2 2 2 0
                2 2 0 0 0
                2 2 1 0 0
            """.trimIndent(),
            expectedScore = 16L,
            expectedMoveList = listOf(
                listOf(
                    4.x() to -1,
                    3.x() to -1,
                    2.x() to 0,
                    1.x() to 0,
                    0.x() to 0,
                ),
                listOf(
                    4.x() to -3,
                    2.x() to -1,
                    1.x() to -1,
                ),
                listOf(
                    4.x() to -2,
                    3.x() to -2,
                    2.x() to -1,
                    1.x() to -1,
                    0.x() to 0,
                ),
            ),
        ),

        MoveTestData(
            inputAreaIndex = 8,
            expectedArea =
            """
                5 4 3 2 1
                2 3 1 0 0
                1 0 0 0 0
            """.trimIndent(),
            expectedScore = 0L,
            expectedMoveList = listOf(
                listOf(
                    4.x() to 0,
                    3.x() to 0,
                    2.x() to 0,
                    1.x() to 0,
                    0.x() to 0,
                ),
                listOf(
                    4.x() to -2,
                    2.x() to -1,
                    0.x() to 0,
                ),
                listOf(
                    0.x() to 0,
                ),
            ),
        ),
    )
)
