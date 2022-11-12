package by.game.binumbers.base.movement

import by.game.binumbers.base.model.Area
import by.game.binumbers.base.movement.action.MoveToDownAction
import by.game.binumbers.base.movement.action.MoveToLeftAction
import by.game.binumbers.base.movement.action.MoveToRightAction
import by.game.binumbers.base.movement.action.MoveToUpAction

enum class MoveDirection {
    MOVE_LEFT,
    MOVE_RIGHT,
    MOVE_UP,
    MOVE_DOWN
}

fun MoveDirection.getMovingAction(prevArea: Area): MoveAction {
    return when (this) {
        MoveDirection.MOVE_LEFT -> MoveToLeftAction(prevArea, this)
        MoveDirection.MOVE_RIGHT -> MoveToRightAction(prevArea, this)
        MoveDirection.MOVE_DOWN -> MoveToDownAction(prevArea, this)
        MoveDirection.MOVE_UP -> MoveToUpAction(prevArea, this)
    }
}
