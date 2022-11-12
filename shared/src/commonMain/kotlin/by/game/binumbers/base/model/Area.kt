package by.game.binumbers.base.model

import kotlin.jvm.JvmInline

@JvmInline
value class Width(val value: Int)

internal fun Int.width() = Width(this)

@JvmInline
value class Height(val value: Int)

internal fun Int.height() = Height(this)

@JvmInline
value class X(val value: Int)

internal fun Int.x() = X(this)

@JvmInline
value class Y(val value: Int)

internal fun Int.y() = Y(this)

internal typealias XY = Pair<X, Y>

@Suppress("TooManyFunctions")
class Area(private val levelId: LevelId) {

    /*
     w = 5
     h = 3

    +--- w --->
    | 0 0 0 0 0
    h 0 0 0 0 0
    | 0 0 0 0 0

     */

    internal val width = levelId.width

    internal val height = levelId.height

    private val totalSize = width * height

    private val cells = Array(totalSize) { CellId.C_EMPTY }

    fun cellsAsList(): List<CellId> = cells.toList()

    internal inline fun setCell(cellId: CellId, index: Int) {
        cells[index] = cellId
    }

    internal inline fun setCell(cellId: CellId, x: X, y: Y) {
        cells[y.value * width + x.value] = cellId
    }

    internal inline fun getCell(x: X, y: Y): CellId = cells[y.value * width + x.value]

    internal inline fun getCell(pos: XY): CellId = getCell(pos.first, pos.second)

    internal inline fun cellsAreEquals(x1: X, y1: Y, x2: X, y2: Y): Boolean =
        getCell(x1, y1) == getCell(x2, y2)

    internal fun setEmptyCell(x: X, y: Y) {
        setCell(CellId.C_EMPTY, x, y)
    }

    private fun atLeastOneEmptyCell(): Boolean = cells.contains(CellId.C_EMPTY)

    internal fun isEmptyCell(x: X, y: Y): Boolean = getCell(x, y) == CellId.C_EMPTY

    internal fun isNotEmptyCell(x: X, y: Y): Boolean = isEmptyCell(x, y).not()

    internal fun isAreaEmpty(): Boolean = cells.all { it == CellId.C_EMPTY }

    internal fun addRandomCell(randomizer: Randomizer): Boolean {
        val listOfEmptyCells = mutableListOf<Int>()
        for (index in 0 until totalSize) {
            if (cells[index] == CellId.C_EMPTY) {
                listOfEmptyCells.add(index)
            }
        }
        return if (listOfEmptyCells.isNotEmpty()) {
            setCell(randomizer.getRandomCell(), randomizer.shuffleList(listOfEmptyCells).first())
            true
        } else {
            false
        }
    }

    internal fun fillAll(cell: CellId) {
        for (index in 0 until totalSize) {
            cells[index] = cell
        }
    }

    internal fun incrementCell(x: X, y: Y) {
        val index = y.value * width + x.value
        cells[index] = CellId.getNextCell(cells[index])
    }

    internal fun copy(): Area {
        val area = Area(levelId)
        this.cells.forEachIndexed { index, cell ->
            area.cells[index] = cell
        }
        return area
    }

    internal fun checkWin(): Boolean = cells.contains(levelId.winCellId)

    @Suppress("ReturnCount")
    internal fun checkLose(): Boolean {
        if (atLeastOneEmptyCell()) {
            return false
        }

        for (h in 0 until height - 1) {
            if (cellsAreEquals(X(width - 1), Y(h), X(width - 1), Y(h + 1))) {
                return false
            }
        }

        for (w in 0 until width - 1) {
            if (cellsAreEquals(X(w), Y(height - 1), X(w + 1), Y(height - 1))) {
                return false
            }
        }

        for (w in 0 until width - 1) {
            for (h in 0 until height - 1) {
                if (cellsAreEquals(
                        X(w),
                        Y(h),
                        X(w),
                        Y(h + 1)
                    ) || cellsAreEquals(X(w), Y(h), X(w + 1), Y(h))
                ) {
                    return false
                }
            }
        }
        return true
    }

    internal fun findMaxCell(): CellId = cells.maxByOrNull { it.value } ?: CellId.C_EMPTY

    internal fun clearArea() {
        for (index in 0 until totalSize) {
            cells[index] = CellId.C_EMPTY
        }
    }

    internal fun swapCells(x1: X, y1: Y, x2: X, y2: Y) {
        if (cellsAreEquals(x1, y1, x2, y2)) {
            return
        }
        val tmpCell = getCell(x1, y1)
        setCell(getCell(x2, y2), x1, y1)
        setCell(tmpCell, x2, y2)
    }

    override fun toString(): String {
        val answer = StringBuilder()
        for (h in 0 until height) {
            val rowSeparator = if (h == height - 1) "" else "\n"
            for (w in 0 until width) {
                val columnSeparator = if (w == width - 1) "" else " "
                answer.append("${getCell(X(w), Y(h)).id}$columnSeparator")
            }
            answer.append(rowSeparator)
        }
        return answer.toString()
    }

    companion object {
        val IMPOSSIBLE_AREA = Area(LevelId.L_IMPOSSIBLE)
    }
}

fun String.provideAreaByString(
    levelId: LevelId = LevelId.L_TEST_ONLY_5_X_3,
    columnDivider: String = " ",
    lineDivider: String = "\n"
): Area {
    val area = Area(levelId)
    val rows = this.split(lineDivider)
    var rIndex = 0
    for (row in rows) {
        val columns = row.trim().split(columnDivider)

        var cIndex = 0
        for (column in columns) {
            area.setCell(CellId.getCellIdById(column.toInt()), cIndex.x(), rIndex.y())
            cIndex += 1
        }
        rIndex += 1
    }
    return area
}
