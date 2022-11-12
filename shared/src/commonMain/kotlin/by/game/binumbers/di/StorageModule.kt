package by.game.binumbers.di

import by.game.binumbers.base.storage.KeyValueStorage
import by.game.binumbers.base.storage.KeyValueStorageImpl
import com.russhwolf.settings.Settings
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newFixedThreadPoolContext
import org.koin.dsl.module

private const val THREAD_NUMBER = 64

@OptIn(ExperimentalCoroutinesApi::class)
internal val StorageModule = module {

    val ioDispatcher = newFixedThreadPoolContext(THREAD_NUMBER, "io")
    single { KeyValueStorageImpl(Settings(), ioDispatcher) as KeyValueStorage }
}
