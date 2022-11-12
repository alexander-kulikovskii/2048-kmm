package by.game.binumbers.settings.data.repository

import by.game.binumbers.settings.data.source.local.SettingsLocalDataSource
import by.game.binumbers.settings.data.source.platform.SettingsPlatformDataSource
import by.game.binumbers.settings.domain.boundary.repository.SettingsRepository

@Suppress("TooManyFunctions")
class SettingsRepositoryImpl(
    private val settingsLocalDataSource: SettingsLocalDataSource,
    private val settingsPlatformDataSource: SettingsPlatformDataSource,
) : SettingsRepository {
    override suspend fun restoreAnimationSpeed(): Long {
        return settingsLocalDataSource.restoreAnimationSpeed()
    }

    override suspend fun restoreAnimationEnabled(): Boolean {
        return settingsLocalDataSource.restoreAnimationEnabled()
    }

    override suspend fun restoreCellBrightness(): Long {
        return settingsLocalDataSource.restoreCellBrightness()
    }

    override suspend fun restoreDarkMode(): Boolean {
        return settingsLocalDataSource.restoreDarkMode()
    }

    override suspend fun restoreDynamicThemeMode(): Boolean {
        return settingsLocalDataSource.restoreDynamicThemeMode()
    }

    override suspend fun restoreIsDynamicThemeSupported(): Boolean {
        return settingsPlatformDataSource.isDynamicColorsSupported()
    }

    override suspend fun restoreVibrationEnabled(): Boolean {
        return settingsLocalDataSource.restoreVibrationEnabled()
    }

    override suspend fun saveAnimationSpeed(value: Long) {
        return settingsLocalDataSource.saveAnimationSpeed(value)
    }

    override suspend fun saveAnimationEnabled(value: Boolean) {
        return settingsLocalDataSource.saveAnimationEnabled(value)
    }

    override suspend fun saveCellBrightness(value: Long) {
        return settingsLocalDataSource.saveCellBrightness(value)
    }

    override suspend fun saveDarkMode(value: Boolean) {
        return settingsLocalDataSource.saveDarkMode(value)
    }

    override suspend fun saveDynamicThemeMode(value: Boolean) {
        return settingsLocalDataSource.saveDynamicThemeMode(value)
    }

    override suspend fun saveVibrationEnabled(value: Boolean) {
        return settingsLocalDataSource.saveVibrationEnabled(value)
    }
}
