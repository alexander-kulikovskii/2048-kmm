package by.game.binumbers.settings.domain

import by.game.binumbers.settings.domain.usecase.RestoreDarkThemeUseCase
import by.game.binumbers.settings.domain.usecase.RestoreDynamicColorsIsSupportedUseCase
import by.game.binumbers.settings.domain.usecase.RestoreDynamicColorsUseCase

@Suppress("TooManyFunctions")
class SettingsUseCasesFacadeImpl(
    private val restoreDarkThemeUseCase: RestoreDarkThemeUseCase,
    private val restoreDynamicColorsIsSupportedUseCase: RestoreDynamicColorsIsSupportedUseCase,
    private val restoreDynamicColorsUseCase: RestoreDynamicColorsUseCase,
) : SettingsUseCasesFacade {
    override suspend fun restoreAnimationSpeed(): Long {
        TODO("Not yet implemented")
    }

    override suspend fun restoreAnimationEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun restoreCellBrightness(): Long {
        TODO("Not yet implemented")
    }

    override suspend fun restoreDarkMode(): Boolean {
        return restoreDarkThemeUseCase()
    }

    override suspend fun restoreDynamicThemeMode(): Boolean {
        return restoreDynamicColorsUseCase()
    }

    override suspend fun restoreIsDynamicThemeSupported(): Boolean {
        return restoreDynamicColorsIsSupportedUseCase()
    }

    override suspend fun restoreVibrationEnabled(): Boolean {
        return true
    }

    override suspend fun saveAnimationSpeed(value: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun saveAnimationEnabled(value: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun saveCellBrightness(value: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun saveDarkMode(value: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun saveDynamicThemeMode(value: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun saveVibrationEnabled(value: Boolean) {
        TODO("Not yet implemented")
    }
}
