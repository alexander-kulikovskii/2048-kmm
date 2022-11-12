package by.game.binumbers.screen.game

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.TouchInjectionScope
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
import androidx.compose.ui.test.swipeUp
import by.game.binumbers.base.model.CellId
import by.game.binumbers.game.domain.generated.GameState
import by.game.binumbers.screen.BaseScreenTest
import by.game.binumbers.screen.composeRule
import org.junit.Before
import org.junit.Test

class GameScreenTest : BaseScreenTest() {

    private val state = GameState(
        progress = false,
        score = 2048L,
        width = 4,
        height = 4,
        cells = listOf(
            CellId.C_EMPTY, CellId.C_2, CellId.C_4, CellId.C_8,
            CellId.C_16, CellId.C_32, CellId.C_64, CellId.C_128,
            CellId.C_256, CellId.C_512, CellId.C_1024, CellId.C_2048,
            CellId.C_4096, CellId.C_8192, CellId.C_16384, CellId.C_32768,
        ),
        undoCount = 5,
    )

    override val generalContent: @Composable () -> Unit =
        {
            GameContent(state = state,
                onMoveLeft = {
                    swipeCount++
                },
                onMoveRight = {
                    swipeCount++
                },
                onMoveDown = {
                    swipeCount++
                },
                onMoveUp = {
                    swipeCount++
                },
                onUndoClick = {
                    undoClicked++
                }
            )
        }

    var swipeCount = 0
    var undoClicked = 0

    @Before
    fun setUp() {
        swipeCount = 0
        undoClicked = 0
    }

    @Test
    fun allCellsDisplayed() {

        listOf("2",
            "4",
            "8",
            "16",
            "32",
            "64",
            "128",
            "256",
            "512",
            "1024",
            "2048",
            "4096",
            "8192").map {
            rule.cellIsDisplayed(it)
        }
    }

    @Test
    fun scoreDisplayed() {
        rule.onNodeWithText("2048").assertExists()
    }

    @Test
    fun undoEnabledDisplayed() {
        rule.onNodeWithContentDescription("Undo button").apply {
            assertExists()
            assertIsDisplayed()
            assertHasClickAction()
        }
        rule.onNodeWithText("5").assertExists()
    }

//    @Test
//    fun undoDisabledDisplayed() {
//        rule.onNodeWithContentDescription("Undo button").apply {
//            assertExists()
//            assertIsDisplayed()
//            assertHasNoClickAction()
//        }
//        rule.onNodeWithText("5").assertExists()
//    }

    @Test
    fun swipeLeft() {
        rule.swipeMade { swipeLeft() }
    }

    @Test
    fun swipeRight() {
        rule.swipeMade { swipeRight() }
    }

    @Test
    fun swipeDown() {
        rule.swipeMade { swipeDown() }
    }

    @Test
    fun swipeUp() {
        rule.swipeMade { swipeUp() }
    }

    private fun composeRule<ComponentActivity>.swipeMade(block: TouchInjectionScope.() -> Unit) {
        this.onRoot().performTouchInput(block)
        assert(swipeCount == 1)
    }

    private fun composeRule<ComponentActivity>.cellIsDisplayed(name: String) {
        this.onNodeWithContentDescription("Cell $name").apply {
            assertIsDisplayed()
            assertExists()
        }
    }
}
