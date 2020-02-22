package com.afkoders.hackathon.di.modules

import android.app.Application
import android.content.Context
import com.afkoders.hackathon.HackathonApplication
import com.afkoders.hackathon.data.prefs.AppPrefs
import com.afkoders.hackathon.data.service.ApiServiceModule
import com.afkoders.hackathon.di.qualifiers.ApplicationContext
import com.afkoders.hackathon.di.scope.ApplicationScope
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module(includes = [ActivityBindingModule::class, ApiServiceModule::class])
abstract class ApplicationModule {

    @Binds
    @ApplicationContext
    abstract fun bindContext(hackathonApplication: HackathonApplication): Context

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideApplication(hackathonApplication: HackathonApplication): Application {
            return hackathonApplication
        }

        @Provides
        @ApplicationScope
        @JvmStatic
        fun provideHistoryPrefs(@ApplicationContext context: Context, gson: Gson): AppPrefs {
            return AppPrefs(context, gson)
        }
    }
}