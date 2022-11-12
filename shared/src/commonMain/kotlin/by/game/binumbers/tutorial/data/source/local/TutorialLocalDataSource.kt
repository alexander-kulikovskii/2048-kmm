package by.game.binumbers.tutorial.data.source.local

interface TutorialLocalDataSource {

    suspend fun getTutorialShown(): Boolean

    suspend fun saveTutorialAsShown()
}
