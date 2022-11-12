package by.game.binumbers.game.domain.generated

import `by`.game.binumbers.base.BinumbersState
import by.game.binumbers.base.model.CellId
import kotlin.Boolean

data class GameState(
    val progress: Boolean,
    val cells: List<CellId> = emptyList(), // TODO think about decomposition for faster UI update. Only some elements
    val width: Int = 4,
    val height: Int = 4,
    val score: Long = 0L,
    val undoEnabled: Boolean = false,
    val undoCount: Long = 0L,
) : BinumbersState {
    companion object {
        val initial: GameState = GameState(progress = true)
    }
}
