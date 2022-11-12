package by.game.binumbers.base.storage

import com.russhwolf.settings.Settings
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class KeyValueStorageImpl(
    private val settings: Settings,
    private val ioDispatcher: CoroutineContext,
) : KeyValueStorage {

    override suspend fun getInt(key: String, defaultValue: Int): Int =
        withContext(ioDispatcher) { settings.getInt(key, defaultValue) }

    override suspend fun getLong(key: String, defaultValue: Long): Long =
        withContext(ioDispatcher) { settings.getLong(key, defaultValue) }

    override suspend fun getBoolean(key: String, defaultValue: Boolean): Boolean =
        withContext(ioDispatcher) { settings.getBoolean(key, defaultValue) }

    override suspend fun saveInt(key: String, value: Int) = withContext(ioDispatcher) {
        settings.putInt(key, value)
    }

    override suspend fun saveLong(key: String, value: Long) = withContext(ioDispatcher) {
        settings.putLong(key, value)
    }

    override suspend fun saveBoolean(key: String, value: Boolean) = withContext(ioDispatcher) {
        settings.putBoolean(key, value)
    }
}
