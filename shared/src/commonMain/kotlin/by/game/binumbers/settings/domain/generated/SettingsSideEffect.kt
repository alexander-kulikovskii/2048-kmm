package by.game.binumbers.settings.domain.generated

import by.game.binumbers.settings.domain.model.Error
import by.game.binumbers.settings.domain.model.SettingsSideEffect
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlin.String

internal suspend fun MutableSharedFlow<SettingsSideEffect>.emitError(errorMessage: String) {
    emit(Error(Exception(errorMessage)))
}
