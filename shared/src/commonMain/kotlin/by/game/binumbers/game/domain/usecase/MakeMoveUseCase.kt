package by.game.binumbers.game.domain.usecase

import by.game.binumbers.base.model.Area
import by.game.binumbers.base.model.Randomizer
import by.game.binumbers.base.movement.MoveDirection
import by.game.binumbers.base.movement.getMovingAction

class MakeMoveUseCase(private val randomizer: Randomizer) {

    operator fun invoke(
        moveDirection: MoveDirection,
        prevArea: Area,
        prevScore: Long,
    ): Triple<Boolean, Area, Long> {
        val moveAction = moveDirection.getMovingAction(prevArea)
        moveAction.makeMove()
        return if (moveAction.moveDone) {
            val newArea = moveAction.getOutputArea().copy().apply {
                addRandomCell(randomizer)
            }
            val newScore = prevScore + moveAction.afterMoveIncrementScoreValue
            Triple(true, newArea, newScore)
        } else {
            Triple(false, Area.IMPOSSIBLE_AREA, -1L)
        }
    }
}
