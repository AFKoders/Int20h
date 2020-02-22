package com.afkoders.batteryme.presentation

import android.content.Context
import com.afkoders.batteryme.di.qualifiers.ActivityContext
import com.afkoders.batteryme.di.scope.FragmentScope
import com.afkoders.batteryme.presentation.login.LoginAgreement
import com.afkoders.batteryme.presentation.login.LoginFragment
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

    @FragmentScope
    @ContributesAndroidInjector
    fun loginFragment(): LoginFragment?

    @Binds
    fun testPresenter(testPresenter: TestPresenter): TestAgreement.Presenter

    @Binds
    fun loginPresenter(testPresenter: TestPresenter): LoginAgreement.Presenter

    @ActivityContext
    @Binds
    fun bindActivityContext(mainActivity: MainActivity): Context
}