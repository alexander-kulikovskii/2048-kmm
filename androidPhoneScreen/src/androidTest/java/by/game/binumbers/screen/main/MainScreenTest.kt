package by.game.binumbers.screen.main

import MainContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import by.game.binumbers.main.domain.generated.MainState
import by.game.binumbers.screen.BaseScreenTest
import by.game.binumbers.screen.R
import by.game.binumbers.screen.existsAndClickable
import org.junit.Test

class MainScreenTest : BaseScreenTest() {

    override val generalContent: @Composable () -> Unit =
        { MainContent(state = MainState(progress = false)) }

    @Test
    fun checkLogo() {
        rule.onNodeWithContentDescription("Logo icon").apply {
            assertExists()
            assertIsDisplayed()
        }
    }

    @Test
    fun checkStartButton() {
        val startTest = rule.activity.getString(R.string.start_game)
        rule.onNodeWithText(startTest).existsAndClickable()
    }

    @Test
    fun checkStatButton() {
        val statisticsTest = rule.activity.getString(R.string.start_game)

        rule.onNodeWithText(statisticsTest).existsAndClickable()
    }

    @Test
    fun checkSettingsButton() {
        rule.onNodeWithContentDescription("Settings button").existsAndClickable()
    }
}
