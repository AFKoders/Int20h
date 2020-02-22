package com.afkoders.batteryme.presentation

import android.content.Context
import com.afkoders.batteryme.di.qualifiers.ActivityContext
import com.afkoders.batteryme.di.scope.FragmentScope
import com.afkoders.batteryme.presentation.battery.BatteryAgreement
import com.afkoders.batteryme.presentation.battery.BatteryFragment
import com.afkoders.batteryme.presentation.battery.BatteryPresenter
import com.afkoders.batteryme.presentation.challenges.ChallengesAgreement
import com.afkoders.batteryme.presentation.challenges.ChallengesFragment
import com.afkoders.batteryme.presentation.challenges.ChallengesPresenter
import com.afkoders.batteryme.presentation.events.EventsAgreement
import com.afkoders.batteryme.presentation.events.EventsFragment
import com.afkoders.batteryme.presentation.events.EventsPresenter
import com.afkoders.batteryme.presentation.leaderboard.LeaderboardAgreement
import com.afkoders.batteryme.presentation.leaderboard.LeaderboardFragment
import com.afkoders.batteryme.presentation.leaderboard.LeaderboardPresenter
import com.afkoders.batteryme.presentation.main.MainFragment
import com.afkoders.batteryme.presentation.main.MainFragmentAgreement
import com.afkoders.batteryme.presentation.main.MainFragmentPresenter
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

    @FragmentScope
    @ContributesAndroidInjector
    fun mainFragment(): MainFragment?

    @Binds
    fun mainFragmentPresenter(mainFragmentPresenter: MainFragmentPresenter): MainFragmentAgreement.Presenter

    @FragmentScope
    @ContributesAndroidInjector
    fun batteryFragment(): BatteryFragment?

    @Binds
    fun batteryFragmentPresenter(batteryFragmentPresenter: BatteryPresenter): BatteryAgreement.Presenter

    @FragmentScope
    @ContributesAndroidInjector
    fun eventsFragment(): EventsFragment?

    @Binds
    fun eventsFragmentPresenter(eventsFragmentPresenter: EventsPresenter): EventsAgreement.Presenter

    @FragmentScope
    @ContributesAndroidInjector
    fun challengesFragment(): ChallengesFragment?

    @Binds
    fun challengesFragmentPresenter(challengesFragmentPresenter: ChallengesPresenter): ChallengesAgreement.Presenter

    @FragmentScope
    @ContributesAndroidInjector
    fun leaderboardFragment(): LeaderboardFragment?

    @Binds
    fun leaderboardFragmentPresenter(leaderboardFragmentPresenter: LeaderboardPresenter): LeaderboardAgreement.Presenter

    @ActivityContext
    @Binds
    fun bindActivityContext(mainActivity: MainActivity): Context
}