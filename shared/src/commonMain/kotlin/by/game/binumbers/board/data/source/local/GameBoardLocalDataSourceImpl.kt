package by.game.binumbers.board.data.source.local

import by.game.binumbers.base.model.CellId
import by.game.binumbers.base.model.LevelId
import by.game.binumbers.base.storage.KeyValueStorage

class GameBoardLocalDataSourceImpl(private val keyValueStorage: KeyValueStorage) :
    GameBoardLocalDataSource {

    override suspend fun restoreBoard(boardIndex: Int, levelId: LevelId, size: Int): List<CellId> {
        val list = List(size) {
            CellId.getCellIdById(keyValueStorage.getInt(levelId.toKey(boardIndex, it)))
        }
        return list
    }

    override suspend fun saveBoard(boardIndex: Int, levelId: LevelId, cells: List<CellId>) {
        cells.forEachIndexed { index, cell ->
            keyValueStorage.saveInt(levelId.toKey(boardIndex, index), cell.id)
        }
    }

    private fun LevelId.toKey(boardIndex: Int, index: Int): String =
        "${boardIndex}_$KEY_PREFIX${this.id}_$index"

    private companion object {
        private const val KEY_PREFIX = "Game_Board_"
    }
}
