package by.game.binumbers.design.system.components.button

import androidx.compose.runtime.Composable
import by.game.binumbers.screenshot.test.tool.BaseComponentTest

class SettingsButtonTest : BaseComponentTest() {
    override val content: @Composable () -> Unit = { SettingsButton() }
}
