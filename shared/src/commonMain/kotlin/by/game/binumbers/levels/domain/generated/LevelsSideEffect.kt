package by.game.binumbers.levels.domain.generated

import `by`.game.binumbers.levels.domain.model.Error
import by.game.binumbers.levels.domain.model.LevelsSideEffect
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlin.String

internal suspend fun MutableSharedFlow<LevelsSideEffect>.emitError(errorMessage: String) {
    emit(Error(Exception(errorMessage)))
}
