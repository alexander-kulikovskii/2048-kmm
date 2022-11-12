package by.game.binumbers.settings.data.source.local

import by.game.binumbers.base.storage.KeyValueStorage

@Suppress("TooManyFunctions")
class SettingsLocalDataSourceImpl(private val keyValueStorage: KeyValueStorage) :
    SettingsLocalDataSource {
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
        return keyValueStorage.getBoolean(
            KEY_PREFIX + "dark_mode",
            defaultValue = true
        )
    }

    override suspend fun restoreDynamicThemeMode(): Boolean {
        return keyValueStorage.getBoolean(
            KEY_PREFIX + "dynamic_theme",
            defaultValue = true
        )
    }

    override suspend fun restoreVibrationEnabled(): Boolean {
        TODO("Not yet implemented")
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

    private companion object {
        private const val KEY_PREFIX = "Settings_"
    }
}
