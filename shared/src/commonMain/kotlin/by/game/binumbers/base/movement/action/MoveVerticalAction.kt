package by.game.binumbers.base.movement.action

import by.game.binumbers.base.model.Area
import by.game.binumbers.base.model.X
import by.game.binumbers.base.model.XY
import by.game.binumbers.base.model.Y
import by.game.binumbers.base.movement.MoveAction
import by.game.binumbers.base.movement.MoveDirection
import by.game.binumbers.base.movement.MovingCell

abstract class MoveVerticalAction(oldArea: Area, moveDirection: MoveDirection) :
    MoveAction(oldArea, moveDirection) {

    protected fun swapCellsInColumn(column: X, newRow: Y, row: Y) {
        if (newRow == row) {
            return
        }
        newArea.swapCells(column, row, column, newRow)
    }

    protected fun analyzeVerticalAnimationArrays(
        oldAreaCandidates: Array<XY>,
        tmpAreaCandidates: Array<XY>,
        tmpAreaCandidateCount: Int,
    ) {
        var oldIndex = 0
        for (tmpIndex in 0 until tmpAreaCandidateCount) {
            val to = tmpAreaCandidates[tmpIndex]
            var from = oldAreaCandidates[oldIndex]
            addVerticalMove(from, to)
            if (oldArea.getCell(from) != newArea.getCell(to)) {
                from = oldAreaCandidates[++oldIndex]
                addVerticalMove(from, to)
            }
            oldIndex++
        }
    }

    private fun addVerticalMove(
        from: XY,
        to: XY,
    ) {
        movingCellList.add(
            MovingCell(
                from.first,
                from.second,
                delta = to.second.value - from.second.value,
            )
        )
    }
}
