package by.game.binumbers.base.movement.action

import by.game.binumbers.base.model.Area
import by.game.binumbers.base.model.x
import by.game.binumbers.base.model.y
import by.game.binumbers.base.movement.MoveDirection

class MoveToDownAction(oldArea: Area, moveDirection: MoveDirection) :
    MoveVerticalAction(oldArea, moveDirection) {

    override fun makeMove() {
        for (column in 0 until oldArea.width) {
            moveDone = moveDone or zipToDownColumn(column)
            moveDone = moveDone or mergeToDownColumn(column)
            moveDone = moveDone or zipToDownColumn(column)
        }
        if (moveDone) {
            calculateAnimationToDown()
        }
    }

    private fun zipToDownColumn(column: Int): Boolean {
        var newRow: Int
        var answer = false

        for (row in oldArea.height - 1 downTo 0) {
            if (newArea.isNotEmptyCell(column.x(), row.y())) {
                newRow = row + 1

                while (newRow < newArea.height && newArea.isEmptyCell(column.x(), newRow.y())) {
                    newRow++
                }

                if (newRow == newArea.height || newArea.isNotEmptyCell(column.x(), newRow.y())) {
                    newRow--
                }

                answer = answer or (newRow != row)
                swapCellsInColumn(column.x(), newRow.y(), row.y())
            }
        }
        return answer
    }

    private fun mergeToDownColumn(column: Int): Boolean {
        var answer = false

        for (row in newArea.height - 1 downTo 1) {
            if (newArea.cellsAreEquals(column.x(), row.y(), column.x(), (row - 1).y()) &&
                newArea.isNotEmptyCell(column.x(), row.y())
            ) {
                newArea.incrementCell(column.x(), row.y())
                afterMoveIncrementScoreValue += newArea.getCell(column.x(), row.y()).value
                newArea.setEmptyCell(column.x(), (row - 1).y())
                answer = true
            }
        }
        return answer
    }

    private fun calculateAnimationToDown() {
        for (column in 0 until newArea.width) {

            var oldAreaCandidateCount = 0
            var tmpAreaCandidateCount = 0

            val oldAreaCandidates = Array(newArea.height) { 0.x() to 0.y() }
            val tmpAreaCandidates = Array(newArea.height) { 0.x() to 0.y() }

            for (row in 0 until newArea.height) {
                if (oldArea.isNotEmptyCell(column.x(), row.y())) {
                    oldAreaCandidates[oldAreaCandidateCount++] = column.x() to row.y()
                }
                if (newArea.isNotEmptyCell(column.x(), row.y())) {
                    tmpAreaCandidates[tmpAreaCandidateCount++] = column.x() to row.y()
                }
            }

            analyzeVerticalAnimationArrays(
                oldAreaCandidates,
                tmpAreaCandidates,
                tmpAreaCandidateCount,
            )
        }
    }
}
