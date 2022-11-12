package by.game.binumbers.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import by.game.binumbers.design.system.theme.BinumbersTheme
import by.game.binumbers.design.system.theme.GameTheme
import org.junit.Before
import org.junit.Rule

internal fun SemanticsNodeInteraction.existsAndClickable() {
    this.assertExists()
    this.assertHasClickAction()
}

internal typealias composeRule<A> = AndroidComposeTestRule<ActivityScenarioRule<A>, A>

abstract class BaseScreenTest {

    @get:Rule
    val rule = createAndroidComposeRule<ComponentActivity>()

    abstract val generalContent: (@Composable () -> Unit)?

    fun setContent(content: @Composable () -> Unit) {
        rule.setContent {
            BinumbersTheme(darkTheme = false, useDynamicColor = false) {
                Box(Modifier
                    .fillMaxSize()
                    .background(GameTheme.colors.background)
                ) {
                    content.invoke()
                }
            }
        }
    }

    @Before
    fun setUpContent() {
        if (generalContent != null) {
            setContent(generalContent!!)
        }
    }
}
