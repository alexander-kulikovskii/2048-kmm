package by.game.binumbers.microbenchmark

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.filters.LargeTest
import by.game.binumbers.base.model.CellId
import by.game.binumbers.base.model.LevelId
import by.game.binumbers.base.storage.KeyValueStorageImpl
import by.game.binumbers.board.data.repository.GameBoardRepositoryImpl
import by.game.binumbers.board.data.source.local.GameBoardLocalDataSourceImpl
import by.game.binumbers.board.domain.boundary.repository.GameBoardRepository
import com.russhwolf.settings.Settings
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@LargeTest
@RunWith(Parameterized::class)
class StorageBenchmark(private val cellNumber: Int, private val threadPoolThreadNumber: Int) {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun readStandardBoard() {
        readBoard(threadPoolThreadNumber, DEFAULT_BOARD_SIZE, CellId.C_8)
    }

    @Test
    fun readHugeBoard() {
        readBoard(DEFAULT_THREAD_NUMBER, cellNumber, CellId.C_32768)
    }

    @Test
    fun writeStandardBoard() {
        writeBoard(threadPoolThreadNumber, DEFAULT_BOARD_SIZE, CellId.C_2)
    }

    @Test
    fun writeHugeBoard() {
        writeBoard(DEFAULT_THREAD_NUMBER, cellNumber, CellId.C_16384)
    }

    private fun writeBoard(threadPoolThreadNumber: Int, boardSize: Int, cellId: CellId) {
        val gameBoardRepository = provideBoardRepository(threadPoolThreadNumber)
        benchmarkRule.measureRepeated {
            runBlocking {
                gameBoardRepository.saveBoard(DEFAULT_BOARD_ID,
                    DEFAULT_LEVEL_ID,
                    cells = (0..boardSize).map { cellId })
                runWithTimingDisabled {
                    val t = gameBoardRepository.restoreBoard(DEFAULT_BOARD_ID,
                        DEFAULT_LEVEL_ID,
                        boardSize)
                    assertTrue("All should be ${cellId.id}", t.all { item -> item == cellId })
                    assertEquals("erw", boardSize, t.size)
                }
            }
        }
    }

    private fun readBoard(threadPoolThreadNumber: Int, boardSize: Int, cellId: CellId) {
        val gameBoardRepository = provideBoardRepository(threadPoolThreadNumber)
        benchmarkRule.measureRepeated {
            runBlocking {
                runWithTimingDisabled {
                    gameBoardRepository.saveBoard(DEFAULT_BOARD_ID,
                        DEFAULT_LEVEL_ID,
                        cells = (0..boardSize).map { cellId })
                }
                val t =
                    gameBoardRepository.restoreBoard(DEFAULT_BOARD_ID, DEFAULT_LEVEL_ID, boardSize)
                runWithTimingDisabled {
                    assertEquals("dr", boardSize, t.size)
                    assertTrue("All should be ${cellId.id}", t.all { item -> item == cellId })
                }
            }

        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun provideBoardRepository(threadPoolThreadNumber: Int): GameBoardRepository {
        val ioDispatcher = newFixedThreadPoolContext(threadPoolThreadNumber, "io")
        val gameBoardLocalDataSource = GameBoardLocalDataSourceImpl(
            keyValueStorage = KeyValueStorageImpl(Settings(), ioDispatcher)
        )
        return GameBoardRepositoryImpl(gameBoardLocalDataSource = gameBoardLocalDataSource)
    }

    internal companion object {
        private const val DEFAULT_THREAD_NUMBER = 64
        private const val DEFAULT_BOARD_ID = 0
        private const val DEFAULT_BOARD_SIZE = 16

        private val DEFAULT_LEVEL_ID = LevelId.L_2048

        @Parameterized.Parameters(name = "mode={0} {1}")
        @JvmStatic
        fun parameters(): List<Array<Any>> {
            return listOf(
                1 to 1,
                8 to 2,
                10 to 5,
                4 to 16,
                32 to DEFAULT_THREAD_NUMBER,
                64 to DEFAULT_THREAD_NUMBER,
                128 to DEFAULT_THREAD_NUMBER,
                256 to DEFAULT_THREAD_NUMBER,
            ).map { arrayOf(it.first, it.second) }
        }
    }
}
