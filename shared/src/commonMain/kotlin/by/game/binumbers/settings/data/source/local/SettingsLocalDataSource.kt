package by.game.binumbers.settings.data.source.local

@Suppress("TooManyFunctions")
interface SettingsLocalDataSource {

    suspend fun restoreAnimationSpeed(): Long
    suspend fun restoreAnimationEnabled(): Boolean
    suspend fun restoreCellBrightness(): Long
    suspend fun restoreDarkMode(): Boolean
    suspend fun restoreDynamicThemeMode(): Boolean
    suspend fun restoreVibrationEnabled(): Boolean

    suspend fun saveAnimationSpeed(value: Long)
    suspend fun saveAnimationEnabled(value: Boolean)
    suspend fun saveCellBrightness(value: Long)
    suspend fun saveDarkMode(value: Boolean)
    suspend fun saveDynamicThemeMode(value: Boolean)
    suspend fun saveVibrationEnabled(value: Boolean)
}
