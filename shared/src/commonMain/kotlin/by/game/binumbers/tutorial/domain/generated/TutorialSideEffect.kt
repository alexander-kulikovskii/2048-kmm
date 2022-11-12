package by.game.binumbers.tutorial.domain.generated

import by.game.binumbers.tutorial.domain.model.Error
import by.game.binumbers.tutorial.domain.model.TutorialSideEffect
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlin.String

internal suspend fun MutableSharedFlow<TutorialSideEffect>.emitError(errorMessage: String) {
    emit(Error(Exception(errorMessage)))
}
