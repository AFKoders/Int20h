package com.afkoders.batteryme.data.repository

import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
    @Binds
    fun provideRepository(apiRepository: RepositoryImpl): Repository
}