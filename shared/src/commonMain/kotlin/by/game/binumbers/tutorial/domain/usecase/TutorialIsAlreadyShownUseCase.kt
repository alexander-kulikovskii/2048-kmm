package by.game.binumbers.tutorial.domain.usecase

import by.game.binumbers.tutorial.domain.boundary.repository.TutorialRepository

class TutorialIsAlreadyShownUseCase(private val tutorialRepository: TutorialRepository) {

    suspend operator fun invoke(): Boolean = tutorialRepository.getTutorialShown()
}
