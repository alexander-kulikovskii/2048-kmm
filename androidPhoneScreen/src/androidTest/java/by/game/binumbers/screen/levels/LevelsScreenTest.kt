package by.game.binumbers.screen.levels

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import by.game.binumbers.base.model.LevelId
import by.game.binumbers.levels.domain.generated.LevelsState
import by.game.binumbers.screen.BaseScreenTest
import by.game.binumbers.screen.composeRule
import org.junit.Before
import org.junit.Test

class LevelsScreenTest : BaseScreenTest() {

    override val generalContent: (@Composable () -> Unit)? = null

    private var clickedLevelId: LevelId? = null
    private var clickedBackButton: Boolean = false

    private val initialState = LevelsState(
        progress = false,
        level2048Enable = false,
        level4096Enable = false,
        level8192Enable = false,
        levelUnlimitedEnable = false,
    )

    private val allLevelsAvailable = LevelsState(
        progress = false,
        level2048Enable = true,
        level4096Enable = true,
        level8192Enable = true,
        levelUnlimitedEnable = true,
    )

    @Before
    fun setUp() {
        clickedLevelId = null
        clickedBackButton = false
    }

    @Test
    fun backButtonClick() {
        setContent {
            LevelsContent(
                state = initialState,
                onBackClick = {
                    clickedBackButton = true
                },
                onLevelClick = {
                    clickedLevelId = it
                },
            )
        }
        rule.backButtonAvailableAndClickable()
    }

    @Test
    fun allLevelsDisabled() {
        setContent {
            LevelsContent(
                state = initialState,
                onBackClick = {},
                onLevelClick = {
                    clickedLevelId = it
                },
            )
        }
        listOf("2048", "4096", "8192", "time").forEach {
            rule.levelNotAvailable(it)
        }
    }

    @Test
    fun onlyFirstLevelEnable() {
        setContent {
            LevelsContent(
                state = initialState.copy(level2048Enable = true),
                onBackClick = {},
                onLevelClick = {
                    clickedLevelId = it
                },
            )
        }
        rule.levelAvailableAndClickable("2048", LevelId.L_2048)
        listOf("4096", "8192", "time").forEach {
            rule.levelNotAvailable(it)
        }
    }

    @Test
    fun allLevelsEnable() {
        setContent {
            LevelsContent(
                state = allLevelsAvailable,
                onBackClick = {},
                onLevelClick = {
                    clickedLevelId = it
                },
            )
        }
        mapOf("2048" to LevelId.L_2048,
            "4096" to LevelId.L_4096,
            "8192" to LevelId.L_8192,
            "time" to LevelId.L_UNLIMITED).forEach { (name, levelId) ->
            rule.levelAvailableAndClickable(name, levelId)
        }
    }

    private fun composeRule<ComponentActivity>.levelNotAvailable(name: String) {
        this.onNodeWithContentDescription("Cell $name").apply {
            assertIsDisplayed()
            assertIsNotEnabled()
            performClick()
            assert(clickedLevelId == null)
        }
    }

    private fun composeRule<ComponentActivity>.levelAvailableAndClickable(
        name: String,
        expectedLevelId: LevelId,
    ) {
        this.onNodeWithContentDescription("Cell $name").apply {
            assertIsDisplayed()
            assertIsEnabled()
            assertHasClickAction()
            performClick()
            assert(clickedLevelId == expectedLevelId)
            clickedLevelId = null
        }
    }

    private fun composeRule<ComponentActivity>.backButtonAvailableAndClickable() {
        this.onNodeWithContentDescription("Back button").apply {
            assertIsDisplayed()
            assertIsEnabled()
            assertHasClickAction()
            performClick()
            assert(clickedBackButton)
            clickedBackButton = false
        }
    }
}
