package com.afkoders.batteryme.data.repository

import com.afkoders.batteryme.data.service.ApiService
import dagger.Binds
import dagger.Module
import io.reactivex.Scheduler
import org.koin.dsl.module.module

@Module
interface RepositoryModule {
    @Binds
    fun provideRepository(apiRepository: RepositoryImpl): Repository
}


val repositoryModule = module {
    single {
        RepositoryImpl(
            get(scopeId = "ApplicationScope") as ApiService,
            get(scopeId = "ApplicationScope", name = "SchedulerUI") as Scheduler,
            get(scopeId = "ApplicationScope", name = "SchedulerIO") as Scheduler
        ) as Repository
    }
}