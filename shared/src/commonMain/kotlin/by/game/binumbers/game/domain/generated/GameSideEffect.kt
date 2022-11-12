package by.game.binumbers.game.domain.generated

import `by`.game.binumbers.game.domain.model.Error
import by.game.binumbers.game.domain.model.GameSideEffect
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlin.String

internal suspend fun MutableSharedFlow<GameSideEffect>.emitError(errorMessage: String) {
    emit(Error(Exception(errorMessage)))
}
