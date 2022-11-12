package by.game.binumbers.settings.domain.usecase

import by.game.binumbers.settings.domain.boundary.repository.SettingsRepository

class RestoreDynamicColorsUseCase(
    private val settingsRepository: SettingsRepository,
) {

    suspend operator fun invoke(): Boolean {
        return settingsRepository.restoreDynamicThemeMode()
    }
}
