package by.game.binumbers.settings.domain.usecase

import by.game.binumbers.settings.domain.boundary.repository.SettingsRepository

class RestoreDarkThemeUseCase(
    private val settingsRepository: SettingsRepository,
) {

    suspend operator fun invoke(): Boolean {
        return settingsRepository.restoreDarkMode()
    }
}
