package by.game.binumbers.settings.domain.boundary.repository

@Suppress("TooManyFunctions")
interface SettingsRepository {

    suspend fun restoreAnimationSpeed(): Long
    suspend fun restoreAnimationEnabled(): Boolean
    suspend fun restoreCellBrightness(): Long
    suspend fun restoreDarkMode(): Boolean
    suspend fun restoreDynamicThemeMode(): Boolean
    suspend fun restoreIsDynamicThemeSupported(): Boolean
    suspend fun restoreVibrationEnabled(): Boolean

    suspend fun saveAnimationSpeed(value: Long)
    suspend fun saveAnimationEnabled(value: Boolean)
    suspend fun saveCellBrightness(value: Long)
    suspend fun saveDarkMode(value: Boolean)
    suspend fun saveDynamicThemeMode(value: Boolean)
    suspend fun saveVibrationEnabled(value: Boolean)
}
