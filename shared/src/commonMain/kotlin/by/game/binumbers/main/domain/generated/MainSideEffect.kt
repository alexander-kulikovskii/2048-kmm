package by.game.binumbers.main.domain.generated

import `by`.game.binumbers.main.domain.model.Error
import `by`.game.binumbers.main.domain.model.MainSideEffect
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlin.String

internal suspend fun MutableSharedFlow<MainSideEffect>.emitError(errorMessage: String) {
    emit(Error(Exception(errorMessage)))
}
