package by.game.binumbers.base.movement

import by.game.binumbers.base.model.Area

abstract class MoveAction(
    protected val oldArea: Area,
    val moveDirection: MoveDirection,
) {

    protected val newArea = oldArea.copy()

    var moveDone = false
        protected set

    var afterMoveIncrementScoreValue: Long = 0
        protected set

    val movingCellList = mutableListOf<MovingCell>()

    abstract fun makeMove()

    fun getOutputArea(): Area = if (moveDone) newArea else oldArea
}
