package com.afkoders.batteryme.presentation

import android.content.Context
import com.afkoders.batteryme.di.qualifiers.ActivityContext
import com.afkoders.batteryme.di.scope.FragmentScope
import com.afkoders.batteryme.presentation.test.TestAgreement
import com.afkoders.batteryme.presentation.test.TestFragment
import com.afkoders.batteryme.presentation.test.TestPresenter
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