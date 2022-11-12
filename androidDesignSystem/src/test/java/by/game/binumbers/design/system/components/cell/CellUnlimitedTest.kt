package by.game.binumbers.design.system.components.cell

import androidx.compose.runtime.Composable
import by.game.binumbers.screenshot.test.tool.BaseComponentTest

class CellUnlimitedTest : BaseComponentTest() {
    override val content: @Composable () -> Unit = { CellUnlimited() }
}
