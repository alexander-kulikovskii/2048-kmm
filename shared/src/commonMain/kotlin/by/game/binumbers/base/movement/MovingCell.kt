package by.game.binumbers.base.movement

import by.game.binumbers.base.model.X
import by.game.binumbers.base.model.Y

class MovingCell(
    val x: X, // from 0 to Width
    val y: Y, // from 0 to Height
    val delta: Int,
)
