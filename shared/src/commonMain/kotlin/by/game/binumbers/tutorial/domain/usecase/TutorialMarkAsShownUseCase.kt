package by.game.binumbers.tutorial.domain.usecase

import by.game.binumbers.tutorial.domain.boundary.repository.TutorialRepository

class TutorialMarkAsShownUseCase(private val tutorialRepository: TutorialRepository) {

    suspend operator fun invoke() {
        tutorialRepository.saveTutorialAsShown()
    }
}
