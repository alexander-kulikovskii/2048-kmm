package by.game.binumbers.screen.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import by.game.binumbers.android.utils.DarkPreviewWrapper
import by.game.binumbers.base.model.CellId
import by.game.binumbers.design.system.components.button.PauseButton
import by.game.binumbers.design.system.components.button.UndoButton
import by.game.binumbers.design.system.components.cell.Cell1024
import by.game.binumbers.design.system.components.cell.Cell128
import by.game.binumbers.design.system.components.cell.Cell16
import by.game.binumbers.design.system.components.cell.Cell2
import by.game.binumbers.design.system.components.cell.Cell2048
import by.game.binumbers.design.system.components.cell.Cell256
import by.game.binumbers.design.system.components.cell.Cell32
import by.game.binumbers.design.system.components.cell.Cell4
import by.game.binumbers.design.system.components.cell.Cell4096
import by.game.binumbers.design.system.components.cell.Cell512
import by.game.binumbers.design.system.components.cell.Cell64
import by.game.binumbers.design.system.components.cell.Cell8
import by.game.binumbers.design.system.components.cell.Cell8192
import by.game.binumbers.design.system.components.cell.CellEmpty
import by.game.binumbers.design.system.components.text.ScoreText
import by.game.binumbers.game.domain.generated.GameState
import by.game.binumbers.screen.R
import by.game.binumbers.screen.extension.eventListener

@Suppress("LongParameterList")
@Composable
fun GameContent(
    state: GameState,
    windowWidthSizeClass: WindowWidthSizeClass = WindowWidthSizeClass.Compact,
    onBackClick: () -> Unit = {},
    onMoveLeft: () -> Unit = {},
    onMoveRight: () -> Unit = {},
    onMoveDown: () -> Unit = {},
    onMoveUp: () -> Unit = {},
    onUndoClick: () -> Unit = {},
    onPauseClick: () -> Unit = {},
) {
    if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
        GameContentPortrait(
            state,
            onBackClick = onBackClick,
            onMoveLeft = onMoveLeft,
            onMoveRight = onMoveRight,
            onMoveDown = onMoveDown,
            onMoveUp = onMoveUp,
            onUndoClick = onUndoClick,
            onPauseClick = onPauseClick,
        )
    } else {
        GameContentLandscape(
            state,
            onBackClick = onBackClick,
            onMoveLeft = onMoveLeft,
            onMoveRight = onMoveRight,
            onMoveDown = onMoveDown,
            onMoveUp = onMoveUp,
            onUndoClick = onUndoClick,
            onPauseClick = onPauseClick,
        )
    }
}

@Composable
@Suppress("LongParameterList")
private fun GameContentPortrait(
    state: GameState,
    onBackClick: () -> Unit = {},
    onMoveLeft: () -> Unit = {},
    onMoveRight: () -> Unit = {},
    onMoveDown: () -> Unit = {},
    onMoveUp: () -> Unit = {},
    onUndoClick: () -> Unit = {},
    onPauseClick: () -> Unit = {},
) {
//    BackHandler(onBack = onBackClick)
    var startX = 0f
    var startY = 0f
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
//            .eventListener(
//                { startX } to { startY },
//                onMoveLeft,
//                onMoveRight,
//                onMoveDown,
//                onMoveUp
//            ) {
//                startX = it.first
//                startY = it.second
//            }
    ) {
        val boxWithConstraintsScope = this
        val h = dimensionResource(id = R.dimen.game_field_padding_horizontal)
        val v = dimensionResource(id = R.dimen.game_field_padding_vertical)
        ScoreText(state.score)
        Row(
            modifier = Modifier.align(Alignment.TopEnd),
        ) {
            UndoButton(
                undoCount = state.undoCount,
//                modifier = Modifier.align(Alignment.TopEnd),
                enabled = state.undoEnabled,
                onClick = onUndoClick,
            )
            PauseButton(onClick = onPauseClick)
        }
        LazyVerticalGrid(
            userScrollEnabled = false,
            columns = GridCells.Fixed(state.width),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .width(boxWithConstraintsScope.maxWidth - v)
                .height(boxWithConstraintsScope.maxWidth - h)
                .padding(8.dp)
                .padding(horizontal = 24.dp)
                .align(Alignment.Center)
                .eventListener(
                    { startX } to { startY },
                    onMoveLeft,
                    onMoveRight,
                    onMoveDown,
                    onMoveUp
                ) {
                    startX = it.first
                    startY = it.second
                }
        ) {
            items(items = state.cells) { cellId ->
                GetCellIconByCellId(cellId)
            }
        }
    }
}

@Composable
@Suppress("LongParameterList")
private fun GameContentLandscape(
    state: GameState,
    onBackClick: () -> Unit = {},
    onMoveLeft: () -> Unit = {},
    onMoveRight: () -> Unit = {},
    onMoveDown: () -> Unit = {},
    onMoveUp: () -> Unit = {},
    onUndoClick: () -> Unit = {},
    onPauseClick: () -> Unit = {},
) {
//    BackHandler(onBack = onBackClick)
    var startX = 0f
    var startY = 0f
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
//            .eventListener(
//                { startX } to { startY },
//                onMoveLeft,
//                onMoveRight,
//                onMoveDown,
//                onMoveUp
//            ) {
//                startX = it.first
//                startY = it.second
//            }
    ) {
        val boxWithConstraintsScope = this
        val h = dimensionResource(id = R.dimen.game_field_padding_horizontal)
        val v = dimensionResource(id = R.dimen.game_field_padding_vertical)
        ScoreText(state.score)
        Column(
            modifier = Modifier.align(Alignment.TopEnd),
        ) {
            UndoButton(
                undoCount = state.undoCount,
//                modifier = Modifier.align(Alignment.TopEnd),
                enabled = state.undoEnabled,
                onClick = onUndoClick,
            )
            PauseButton(onClick = onPauseClick)
        }
        LazyVerticalGrid(
            userScrollEnabled = false,
            columns = GridCells.Fixed(state.width),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .width(boxWithConstraintsScope.maxHeight - v)
                .height(boxWithConstraintsScope.maxHeight - h)
                .padding(48.dp)
                .align(Alignment.Center)
                .eventListener(
                    { startX } to { startY },
                    onMoveLeft,
                    onMoveRight,
                    onMoveDown,
                    onMoveUp
                ) {
                    startX = it.first
                    startY = it.second
                }
        ) {
            items(items = state.cells) { cellId ->
                GetCellIconByCellId(cellId)
            }
        }
    }
}

@Suppress("ComplexMethod")
@Composable
private fun GetCellIconByCellId(cellId: CellId) {
    when (cellId) {
        CellId.C_EMPTY -> CellEmpty()
        CellId.C_2 -> Cell2()
        CellId.C_4 -> Cell4()
        CellId.C_8 -> Cell8()
        CellId.C_16 -> Cell16()
        CellId.C_32 -> Cell32()
        CellId.C_64 -> Cell64()
        CellId.C_128 -> Cell128()
        CellId.C_256 -> Cell256()
        CellId.C_512 -> Cell512()
        CellId.C_1024 -> Cell1024()
        CellId.C_2048 -> Cell2048()
        CellId.C_4096 -> Cell4096()
        CellId.C_8192 -> Cell8192()
        else -> CellEmpty()
    }
}

private val TestState = GameState(
    progress = false,
    cells =
    listOf(
        CellId.C_2,
        CellId.C_4,
        CellId.C_8,
        CellId.C_16,

        CellId.C_256,
        CellId.C_128,
        CellId.C_64,
        CellId.C_32,

        CellId.C_512,
        CellId.C_1024,
        CellId.C_2048,
        CellId.C_4096,

        CellId.C_EMPTY,
        CellId.C_EMPTY,
        CellId.C_EMPTY,
        CellId.C_8192,
    ),
    width = 4,
    height = 4,
    score = 2048,
)

@Preview(showBackground = true, device = Devices.PIXEL_4_XL, showSystemUi = true)
@Preview(showBackground = true, device = Devices.PIXEL_2_XL, showSystemUi = true)
@Preview(showBackground = true, device = Devices.NEXUS_5, showSystemUi = true)
@Preview(showBackground = true, device = Devices.NEXUS_6P, showSystemUi = true)
@Composable
private fun GameContentPreviewPortrait() {
    DarkPreviewWrapper {
        GameContent(TestState)
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_C, showSystemUi = true)
@Preview(showBackground = true, device = Devices.NEXUS_9, showSystemUi = true)
@Composable
private fun GameContentPreviewLandscape() {
    DarkPreviewWrapper {
        GameContent(TestState, windowWidthSizeClass = WindowWidthSizeClass.Expanded)
    }
}
