package by.game.binumbers.di

import android.content.Context
import by.game.binumbers.base.storage.KeyValueStorage
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.mockk
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

abstract class BaseKoinTest(private val modules: List<Module>) : DescribeSpec(), KoinTest {

    init {
        describe("Test koin modules with mocked android context") {

            val mockedAndroidContext = mockk<Context>()
            startKoin {
                androidContext(mockedAndroidContext)
                modules(modules)
            }
            it("check modules") {
                getKoin().checkModules()
            }
            it("stop it") {
                stopKoin()
            }
        }
    }
}

internal val mockedStorageModule = module {
    single<KeyValueStorage> {
        mockk<KeyValueStorage>(relaxUnitFun = true, relaxed = true)
    }
}
