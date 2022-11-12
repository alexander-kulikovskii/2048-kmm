package by.game.binumbers.base.model

private const val DEFAULT_WIDTH = 4
private const val DEFAULT_HEIGHT = 4

@Suppress("MagicNumber")
enum class LevelId(
    val id: Int,
    val width: Int,
    val height: Int,
    val winCellId: CellId,
    val maxUndoCount: Long,
    val forTest: Boolean = false,
) {

    L_2048(
        0,
        width = DEFAULT_WIDTH,
        height = DEFAULT_HEIGHT,
        winCellId = CellId.C_2048,
        maxUndoCount = 5L,
    ),

    L_4096(
        1,
        width = DEFAULT_WIDTH,
        height = DEFAULT_HEIGHT,
        winCellId = CellId.C_4096,
        maxUndoCount = 6L,
    ),

    L_8192(
        2,
        width = DEFAULT_WIDTH,
        height = DEFAULT_HEIGHT,
        winCellId = CellId.C_8192,
        maxUndoCount = 7L,
    ),

    L_UNLIMITED(
        3,
        width = DEFAULT_WIDTH,
        height = DEFAULT_HEIGHT,
        winCellId = CellId.C_UNDEFINED,
        maxUndoCount = 8L,
    ),

    L_TIME(
        4,
        width = DEFAULT_WIDTH,
        height = DEFAULT_HEIGHT,
        winCellId = CellId.C_UNDEFINED,
        maxUndoCount = 0L,
    ),

    L_TEST_ONLY_5_X_3(
        1000,
        width = 5,
        height = 3,
        winCellId = CellId.C_UNDEFINED,
        maxUndoCount = 0L,
        forTest = true,
    ),

    L_IMPOSSIBLE(
        2048,
        width = 4,
        height = 4,
        winCellId = CellId.C_UNDEFINED,
        maxUndoCount = -1L,
    );

    internal companion object {
        private val map = values().associateBy(LevelId::id)

        private val nextLevelMap = mapOf(
            L_2048 to L_4096,
            L_4096 to L_8192,
            L_8192 to L_UNLIMITED
        )

        internal fun getLevelIdById(id: Int) = map[id]!!

        internal fun getGameLevels() = values().filter { !it.forTest }

        internal fun getNextLevel(currentLevel: LevelId): LevelId =
            nextLevelMap.getValue(currentLevel)
    }
}
