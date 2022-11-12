package by.game.binumbers.model

import by.game.binumbers.base.model.Area
import by.game.binumbers.base.model.CellId
import by.game.binumbers.base.model.LevelId
import by.game.binumbers.base.model.Randomizer
import by.game.binumbers.base.model.x
import by.game.binumbers.base.model.y
import by.game.binumbers.base.util.Verify
import by.game.binumbers.base.util.VerifyNo
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class AreaTest : BehaviorSpec({

    Given("Test area. Check `isAreaEmpty`") {
        val levelId = LevelId.L_TEST_ONLY_5_X_3
        val area = Area(levelId)
        When("Check is area empty") {
            val empty = area.isAreaEmpty()
            Then("It should be empty") {
                empty shouldBe true
            }
        }
    }

    Given("Test area. Check `isEmptyCell`") {
        val levelId = LevelId.L_TEST_ONLY_5_X_3
        val area = Area(levelId)
        When("Get cell x(5), y(3)") {
            val empty = area.isEmptyCell(4.x(), 2.y())
            Then("It should be empty") {
                empty shouldBe true
            }
        }
    }

    Given("Test area. Check `addRandomCell`") {
        val levelId = LevelId.L_TEST_ONLY_5_X_3
        val area = Area(levelId)
        val randomizer = mockk<Randomizer>()
        every { randomizer.getRandomCell() } returns CellId.C_2
        every { randomizer.shuffleList(any()) } returns listOf(14)
        When("addRandomCell") {
            val added = area.addRandomCell(randomizer)
            Then("Cell should be added") {
                added shouldBe true
            }
            Then("Check last cell") {
                area.getCell(4.x(), 2.y()) shouldBe CellId.C_2
            }
            Verify("Verify get random cell was called") {
                randomizer.getRandomCell()
            }
            Verify("Verify shuffleList was called") {
                randomizer.shuffleList(any())
            }
        }
    }

    Given("Test area. Check `addRandomCell` when not possible") {
        val levelId = LevelId.L_TEST_ONLY_5_X_3
        val area = Area(levelId)
        area.fillAll(CellId.C_128)
        val randomizer = mockk<Randomizer>()
        When("addRandomCell") {
            val added = area.addRandomCell(randomizer)
            Then("Cell shouldn't be added") {
                added shouldBe false
            }
            Then("Check last cell") {
                area.getCell(4.x(), 2.y()) shouldBe CellId.C_128
            }
            VerifyNo("Verify get random cell wasn't called") {
                randomizer.getRandomCell()
            }
            VerifyNo("Verify shuffleList wasn't called") {
                randomizer.shuffleList(any())
            }
        }
    }

    testNextCellMap.forEach { (currentCell, nextCell) ->
        Given("Test area. Check increment cell for $currentCell") {
            val levelId = LevelId.L_TEST_ONLY_5_X_3
            val area = Area(levelId)
            area.fillAll(currentCell)
            When("Get cell w(0), h(0)") {
                area.incrementCell(0.x(), 0.y())
                Then("It should be empty") {
                    area.getCell(0.x(), 0.y()) shouldBe nextCell
                }
            }
        }
    }

    testWinList.forEach { winAreaData ->
        Given("Test area. Check `checkWin` for $winAreaData") {
            val area = Area(winAreaData.levelId)
            area.fillAll(CellId.C_2)
            area.setCell(
                winAreaData.fillWith,
                (winAreaData.levelId.width * winAreaData.levelId.height) - 1
            )
            When("Call checkWin") {
                val win = area.checkWin()
                Then("It should be ${winAreaData.shouldBeWin}") {
                    win shouldBe winAreaData.shouldBeWin
                }
            }
        }
    }
})

private val testNextCellMap = mapOf(
    CellId.C_EMPTY to CellId.C_EMPTY,
    CellId.C_2 to CellId.C_4,
    CellId.C_4 to CellId.C_8,
    CellId.C_8 to CellId.C_16,
    CellId.C_16 to CellId.C_32,
    CellId.C_32 to CellId.C_64,
    CellId.C_64 to CellId.C_128,
    CellId.C_128 to CellId.C_256,
    CellId.C_256 to CellId.C_512,
    CellId.C_512 to CellId.C_1024,
    CellId.C_1024 to CellId.C_2048,
    CellId.C_2048 to CellId.C_4096,
    CellId.C_4096 to CellId.C_8192,
    CellId.C_8192 to CellId.C_16384,
    CellId.C_16384 to CellId.C_32768,
    CellId.C_32768 to CellId.C_65536,
    CellId.C_65536 to CellId.C_131072,
    CellId.C_131072 to CellId.C_262144,
    CellId.C_262144 to CellId.C_524288,
    CellId.C_524288 to CellId.C_1048576,
    CellId.C_1048576 to CellId.C_UNDEFINED
)

private val testWinList = listOf(
    WinAreaData(LevelId.L_2048, CellId.C_2048, true),
    WinAreaData(LevelId.L_2048, CellId.C_1024, false),
    WinAreaData(LevelId.L_4096, CellId.C_4096, true),
    WinAreaData(LevelId.L_8192, CellId.C_8192, true),
    WinAreaData(LevelId.L_TIME, CellId.C_8192, false),
)

private class WinAreaData(
    val levelId: LevelId,
    val fillWith: CellId,
    val shouldBeWin: Boolean,
)
