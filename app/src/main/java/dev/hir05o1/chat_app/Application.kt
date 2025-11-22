package dev.hir05o1.chat_app

import android.app.Application
import dev.hir05o1.chat_app.data.di.dataModule
import dev.hir05o1.chat_app.data.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            modules(
                listOf(
                    dataModule,
                    domainModule,
                )
            )
        }
    }
}
