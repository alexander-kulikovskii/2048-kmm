package by.game.binumbers.android

import android.app.Application
import by.game.binumbers.di.initKoin
import org.koin.android.ext.koin.androidContext

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@App)
            // TODO add modules here only for this app
        }
    }
}
