package by.game.binumbers.splash.domain.generated

import `by`.game.binumbers.splash.domain.model.Error
import `by`.game.binumbers.splash.domain.model.SplashSideEffect
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlin.String

internal suspend fun MutableSharedFlow<SplashSideEffect>.emitError(errorMessage: String) {
    emit(Error(Exception(errorMessage)))
}
