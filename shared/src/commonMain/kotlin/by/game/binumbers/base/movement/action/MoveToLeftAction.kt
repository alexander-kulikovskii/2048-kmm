package by.game.binumbers.base.movement.action

import by.game.binumbers.base.model.Area
import by.game.binumbers.base.model.x
import by.game.binumbers.base.model.y
import by.game.binumbers.base.movement.MoveDirection

internal class MoveToLeftAction(oldArea: Area, moveDirection: MoveDirection) :
    MoveHorizontalAction(oldArea, moveDirection) {

    override fun makeMove() {
        for (row in 0 until oldArea.height) {
            moveDone = moveDone or zipToLeftRow(row)
            moveDone = moveDone or mergeToLeftRow(row)
            moveDone = moveDone or zipToLeftRow(row)
        }
        if (moveDone) {
            calculateAnimationToLeft()
        }
    }

    private fun zipToLeftRow(row: Int): Boolean {
        var newColumn: Int
        var answer = false

        for (column in 1 until oldArea.width) {
            if (newArea.isNotEmptyCell(column.x(), row.y())) {
                newColumn = column - 1

                while (newColumn >= 0 && newArea.isEmptyCell(newColumn.x(), row.y())) {
                    newColumn--
                }

                if (newColumn == -1 || newArea.isNotEmptyCell(newColumn.x(), row.y())) {
                    newColumn++
                }

                answer = answer or (newColumn != column)
                swapCellsInRow(row.y(), newColumn.x(), column.x())
            }
        }
        return answer
    }

    private fun mergeToLeftRow(row: Int): Boolean {
        var answer = false

        for (column in 0 until newArea.width - 1) {
            if (newArea.cellsAreEquals(column.x(), row.y(), (column + 1).x(), row.y()) &&
                newArea.isNotEmptyCell(column.x(), row.y())
            ) {
                newArea.incrementCell(column.x(), row.y())
                afterMoveIncrementScoreValue += newArea.getCell(column.x(), row.y()).value
                newArea.setEmptyCell((column + 1).x(), row.y())
                answer = true
            }
        }
        return answer
    }

    private fun calculateAnimationToLeft() {
        for (row in 0 until newArea.height) {

            var oldAreaCandidateCount = 0
            var tmpAreaCandidateCount = 0

            val oldAreaCandidates = Array(newArea.width) { 0.x() to 0.y() }
            val tmpAreaCandidates = Array(newArea.width) { 0.x() to 0.y() }

            for (column in newArea.width - 1 downTo 0) {
                if (oldArea.isNotEmptyCell(column.x(), row.y())) {
                    oldAreaCandidates[oldAreaCandidateCount++] = column.x() to row.y()
                }
                if (newArea.isNotEmptyCell(column.x(), row.y())) {
                    tmpAreaCandidates[tmpAreaCandidateCount++] = column.x() to row.y()
                }
            }

            analyzeHorizontalAnimationArrays(
                oldAreaCandidates,
                tmpAreaCandidates,
                tmpAreaCandidateCount,
            )
        }
    }
}
