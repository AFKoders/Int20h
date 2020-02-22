package com.afkoders.batteryme.di.modules

import com.afkoders.batteryme.presentation.MainActivity
import com.afkoders.batteryme.di.scope.ActivityScope
import com.afkoders.batteryme.presentation.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun mainActivity(): MainActivity
}