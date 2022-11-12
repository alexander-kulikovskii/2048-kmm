package by.game.binumbers.screen.extension

import android.view.MotionEvent
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInteropFilter
import kotlin.math.abs

@OptIn(ExperimentalComposeUiApi::class)
@Suppress("LongParameterList")
internal fun Modifier.eventListener(
    startCoordinate: Pair<() -> Float, () -> Float>,
    onMoveLeft: () -> Unit = {},
    onMoveRight: () -> Unit = {},
    onMoveDown: () -> Unit = {},
    onMoveUp: () -> Unit = {},
    updateCoordinates: (Pair<Float, Float>) -> Unit,
) =
    pointerInteropFilter { event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                updateCoordinates(event.x to event.y)
            }
            MotionEvent.ACTION_MOVE -> {}
            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL,
            -> {
                val x = event.x.toInt()
                val y = event.y.toInt()
                val startX = startCoordinate.first.invoke()
                val startY = startCoordinate.second.invoke()
                if (abs(x - startX) > abs(y - startY)) {
                    // offset by X-coordinate
                    if (x - startX > 0) {
                        onMoveRight()
                    } else {
                        onMoveLeft()
                    }
                } else {
                    if (y - startY > 0) {
                        onMoveDown()
                    } else {
                        onMoveUp()
                    }
                }
            }
            else -> false
        }
        true
    }
