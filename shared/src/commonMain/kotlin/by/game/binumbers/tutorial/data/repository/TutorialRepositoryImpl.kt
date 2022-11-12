package by.game.binumbers.tutorial.data.repository

import by.game.binumbers.tutorial.data.source.local.TutorialLocalDataSource
import by.game.binumbers.tutorial.domain.boundary.repository.TutorialRepository

class TutorialRepositoryImpl(private val tutorialLocalDataSource: TutorialLocalDataSource) :
    TutorialRepository {

    override suspend fun getTutorialShown(): Boolean {
        return tutorialLocalDataSource.getTutorialShown()
    }

    override suspend fun saveTutorialAsShown() {
        tutorialLocalDataSource.saveTutorialAsShown()
    }
}
