package com.afkoders.batteryme

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.afkoders.batteryme.data.repository.repositoryModule
import com.afkoders.batteryme.data.service.apiServiceModule
import com.afkoders.batteryme.di.modules.applicationModule
import com.afkoders.batteryme.di.modules.networkModule
import com.afkoders.batteryme.di.modules.rxModule
import com.afkoders.batteryme.presentation.mainActivityModule
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.startKoin

class HackathonApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        val modules = listOf(
            rxModule,
            networkModule,
            repositoryModule,
            applicationModule,
            apiServiceModule,
            mainActivityModule
        )

        startKoin(this@HackathonApplication, modules)
        getKoin().getOrCreateScope("session")
    }

}