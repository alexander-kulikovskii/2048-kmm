package by.game.binumbers.base.model

@Suppress("MagicNumber")
enum class CellId(val id: Int, val value: Int) {

    C_EMPTY(0, 0),
    C_2(1, 2),
    C_4(2, 4),
    C_8(3, 8),
    C_16(4, 16),
    C_32(5, 32),
    C_64(6, 64),
    C_128(7, 128),
    C_256(8, 256),
    C_512(9, 512),
    C_1024(10, 1024),
    C_2048(11, 2048),
    C_4096(12, 4096),
    C_8192(13, 8192),
    C_16384(14, 16384),
    C_32768(15, 32768),
    C_65536(16, 65536),
    C_131072(17, 131072),
    C_262144(18, 262144),
    C_524288(19, 524288),
    C_1048576(20, 1048576),

    C_UNDEFINED(1000, -1);

    internal companion object {
        private val map = values().associateBy(CellId::id)
        private val nextCellMap = mapOf(
            C_EMPTY to C_EMPTY,
            C_2 to C_4,
            C_4 to C_8,
            C_8 to C_16,
            C_16 to C_32,
            C_32 to C_64,
            C_64 to C_128,
            C_128 to C_256,
            C_256 to C_512,
            C_512 to C_1024,
            C_1024 to C_2048,
            C_2048 to C_4096,
            C_4096 to C_8192,
            C_8192 to C_16384,
            C_16384 to C_32768,
            C_32768 to C_65536,
            C_65536 to C_131072,
            C_131072 to C_262144,
            C_262144 to C_524288,
            C_524288 to C_1048576,
            C_1048576 to C_UNDEFINED
        )

        internal fun getCellIdById(id: Int) = map[id] ?: C_EMPTY

        internal fun getNextCell(cellId: CellId): CellId {
            return nextCellMap.getValue(cellId)
        }
    }
}
