package by.game.binumbers.tutorial.data.source.local

import by.game.binumbers.base.storage.KeyValueStorage

class TutorialLocalDataSourceImpl(private val keyValueStorage: KeyValueStorage) :
    TutorialLocalDataSource {
    override suspend fun getTutorialShown(): Boolean {
        return keyValueStorage.getBoolean("${KEY_PREFIX}Shown", false)
    }

    override suspend fun saveTutorialAsShown() {
        keyValueStorage.saveBoolean("${KEY_PREFIX}Shown", true)
    }

    private companion object {
        private const val KEY_PREFIX = "Tutorial_"
    }
}
