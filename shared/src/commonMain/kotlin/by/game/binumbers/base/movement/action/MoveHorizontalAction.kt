package by.game.binumbers.base.movement.action

import by.game.binumbers.base.model.Area
import by.game.binumbers.base.model.X
import by.game.binumbers.base.model.XY
import by.game.binumbers.base.model.Y
import by.game.binumbers.base.movement.MoveAction
import by.game.binumbers.base.movement.MoveDirection
import by.game.binumbers.base.movement.MovingCell

abstract class MoveHorizontalAction(oldArea: Area, moveDirection: MoveDirection) :
    MoveAction(oldArea, moveDirection) {

    protected fun swapCellsInRow(row: Y, newColumn: X, column: X) {
        if (newColumn == column) {
            return
        }
        newArea.swapCells(column, row, newColumn, row)
    }

    protected fun analyzeHorizontalAnimationArrays(
        oldAreaCandidates: Array<XY>,
        tmpAreaCandidates: Array<XY>,
        tmpAreaCandidateCount: Int,
    ) {
        var oldIndex = 0
        for (tmpIndex in 0 until tmpAreaCandidateCount) {
            val to = tmpAreaCandidates[tmpIndex]
            var from = oldAreaCandidates[oldIndex]
            addHorizontalMove(from, to)
            if (oldArea.getCell(from) != newArea.getCell(to)) {
                from = oldAreaCandidates[++oldIndex]
                addHorizontalMove(from, to)
            }
            oldIndex++
        }
    }

    private fun addHorizontalMove(
        from: XY,
        to: XY,
    ) {
        movingCellList.add(
            MovingCell(
                from.first,
                from.second,
                delta = to.first.value - from.first.value,
            )
        )
    }
}
