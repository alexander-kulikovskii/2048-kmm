package by.game.binumbers.android.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver

@Composable
internal fun Lifecycle.observeAsState(onEvent: (Lifecycle.Event) -> Unit) {
    DisposableEffect(this) {
        val observer = LifecycleEventObserver { _, event ->
            onEvent(event)
        }
        this@observeAsState.addObserver(observer)
        onDispose {
            this@observeAsState.removeObserver(observer)
        }
    }
}
