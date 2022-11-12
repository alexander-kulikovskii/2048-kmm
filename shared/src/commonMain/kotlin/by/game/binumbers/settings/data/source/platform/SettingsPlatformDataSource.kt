package by.game.binumbers.settings.data.source.platform

interface SettingsPlatformDataSource {
    suspend fun isDynamicColorsSupported(): Boolean
}
