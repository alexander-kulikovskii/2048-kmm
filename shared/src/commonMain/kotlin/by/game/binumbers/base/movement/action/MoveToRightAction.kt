package by.game.binumbers.base.movement.action

import by.game.binumbers.base.model.Area
import by.game.binumbers.base.model.x
import by.game.binumbers.base.model.y
import by.game.binumbers.base.movement.MoveDirection

class MoveToRightAction(oldArea: Area, moveDirection: MoveDirection) :
    MoveHorizontalAction(oldArea, moveDirection) {

    override fun makeMove() {
        for (row in 0 until oldArea.height) {
            moveDone = moveDone or zipToRightRow(row)
            moveDone = moveDone or mergeToRightRow(row)
            moveDone = moveDone or zipToRightRow(row)
        }
        if (moveDone) {
            calculateAnimationToRight()
        }
    }

    private fun zipToRightRow(row: Int): Boolean {
        var newColumn: Int
        var answer = false

        for (column in oldArea.width - 1 downTo 0) {
            if (newArea.isNotEmptyCell(column.x(), row.y())) {
                newColumn = column + 1

                while (newColumn < newArea.width && newArea.isEmptyCell(newColumn.x(), row.y())) {
                    newColumn++
                }

                if (newColumn == newArea.width || newArea.isNotEmptyCell(newColumn.x(), row.y())) {
                    newColumn--
                }

                answer = answer or (newColumn != column)
                swapCellsInRow(row.y(), newColumn.x(), column.x())
            }
        }
        return answer
    }

    private fun mergeToRightRow(row: Int): Boolean {
        var answer = false

        for (column in newArea.width - 1 downTo 1) {
            if (newArea.cellsAreEquals(column.x(), row.y(), (column - 1).x(), row.y()) &&
                newArea.isNotEmptyCell(column.x(), row.y())
            ) {
                newArea.incrementCell(column.x(), row.y())
                afterMoveIncrementScoreValue += newArea.getCell(column.x(), row.y()).value
                newArea.setEmptyCell((column - 1).x(), row.y())
                answer = true
            }
        }
        return answer
    }

    private fun calculateAnimationToRight() {
        for (row in 0 until newArea.height) {

            var oldAreaCandidateCount = 0
            var tmpAreaCandidateCount = 0

            val oldAreaCandidates = Array(newArea.width) { 0.x() to 0.y() }
            val tmpAreaCandidates = Array(newArea.width) { 0.x() to 0.y() }

            for (column in 0 until newArea.width) {
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
