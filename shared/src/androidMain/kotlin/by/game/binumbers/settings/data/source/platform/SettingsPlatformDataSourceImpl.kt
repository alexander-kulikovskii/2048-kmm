package by.game.binumbers.settings.data.source.platform

import android.os.Build

class SettingsPlatformDataSourceImpl : SettingsPlatformDataSource {
    override suspend fun isDynamicColorsSupported(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    }
}
