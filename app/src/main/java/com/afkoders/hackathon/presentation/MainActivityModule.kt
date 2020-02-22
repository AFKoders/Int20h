package com.afkoders.hackathon.presentation

import android.content.Context
import com.afkoders.hackathon.di.qualifiers.ActivityContext
import com.afkoders.hackathon.di.scope.FragmentScope
import com.afkoders.hackathon.presentation.test.TestAgreement
import com.afkoders.hackathon.presentation.test.TestFragment
import com.afkoders.hackathon.presentation.test.TestPresenter
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface MainActivityModule {
    @FragmentScope
    @ContributesAndroidInjector
    fun testFragment(): TestFragment?

    @Binds
    fun testPresenter(testPresenter: TestPresenter): TestAgreement.Presenter

    @ActivityContext
    @Binds
    fun bindActivityContext(mainActivity: MainActivity): Context
}