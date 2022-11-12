package by.game.binumbers.base.storage

interface KeyValueStorage {
    suspend fun getInt(key: String, defaultValue: Int = 0): Int

    suspend fun getLong(key: String, defaultValue: Long = 0L): Long

    suspend fun getBoolean(key: String, defaultValue: Boolean): Boolean

    suspend fun saveInt(key: String, value: Int)

    suspend fun saveLong(key: String, value: Long)

    suspend fun saveBoolean(key: String, value: Boolean)
}
