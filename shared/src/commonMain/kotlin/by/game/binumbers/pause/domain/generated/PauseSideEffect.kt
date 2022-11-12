package by.game.binumbers.pause.domain.generated

import `by`.game.binumbers.pause.domain.model.Error
import by.game.binumbers.pause.domain.model.PauseSideEffect
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlin.String

internal suspend fun MutableSharedFlow<PauseSideEffect>.emitError(errorMessage: String) {
    emit(Error(Exception(errorMessage)))
}
