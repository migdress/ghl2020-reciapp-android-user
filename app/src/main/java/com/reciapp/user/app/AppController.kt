package com.reciapp.user.app

import android.app.Application
import com.reciapp.user.presentation.di.apiModule
import com.reciapp.user.presentation.di.preferencesModule
import com.reciapp.user.presentation.di.repositoryModule
import com.reciapp.user.presentation.di.useCasesModule
import com.reciapp.user.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by Jorge Henao on 30/05/20.
 */
class AppController: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@AppController)
            modules(
                listOf(
                    apiModule,
                    preferencesModule,
                    repositoryModule,
                    useCasesModule,
                    viewModelModule
                )
            )
        }
    }
}
