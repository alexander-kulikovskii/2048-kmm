package by.game.binumbers.tutorial.domain.boundary.repository

interface TutorialRepository {

    suspend fun getTutorialShown(): Boolean

    suspend fun saveTutorialAsShown()
}
