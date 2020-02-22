package com.afkoders.batteryme.di.modules

import android.app.Application
import android.content.Context
import com.afkoders.batteryme.HackathonApplication
import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.data.service.ApiServiceModule
import com.afkoders.batteryme.di.qualifiers.ApplicationContext
import com.afkoders.batteryme.di.scope.ApplicationScope
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
        fun provideAppPrefs(@ApplicationContext context: Context, gson: Gson): AppPrefs {
            return AppPrefs(context, gson)
        }
    }
}