package by.game.binumbers.design.system.components.button

import androidx.compose.runtime.Composable
import by.game.binumbers.screenshot.test.tool.BaseComponentTest

class UndoButtonTest : BaseComponentTest() {
    override val content: @Composable () -> Unit = { UndoButton(undoCount = 3) }
}
