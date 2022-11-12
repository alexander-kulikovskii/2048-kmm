package by.game.binumbers.base.extension

import by.game.binumbers.base.BinumbersNavigation
import by.game.binumbers.base.navigation.FromScreen
import by.game.binumbers.base.navigation.Navigation
import by.game.binumbers.base.navigation.PopBack
import by.game.binumbers.base.navigation.ToScreen
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.coroutines.Continuation

suspend inline fun <T> suspendCoroutineWithTimeout(
    timeoutMs: Long,
    crossinline block: (Continuation<T>) -> Unit,
): T? {
    var finalValue: T? = null
    withTimeoutOrNull(timeoutMs) {
        finalValue = suspendCancellableCoroutine(block = block)
    }
    return finalValue
}

suspend fun MutableSharedFlow<BinumbersNavigation>.emitNavigation(
    from: FromScreen,
    to: ToScreen,
    inclusiveScreen: Boolean = false,
) {
    this.emit(Navigation(from = from, to = to, inclusiveScreen = inclusiveScreen))
}

suspend fun MutableSharedFlow<BinumbersNavigation>.emitPopBack(
    from: FromScreen,
    to: ToScreen,
    removeCount: Int = 1,
) {
    this.emit(PopBack(from = from, to = to, removeCount = removeCount))
}
