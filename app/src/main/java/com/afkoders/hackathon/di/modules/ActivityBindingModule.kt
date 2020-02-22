package com.afkoders.hackathon.di.modules

import com.afkoders.hackathon.presentation.MainActivity
import com.afkoders.hackathon.di.scope.ActivityScope
import com.afkoders.hackathon.presentation.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun mainActivity(): MainActivity
}