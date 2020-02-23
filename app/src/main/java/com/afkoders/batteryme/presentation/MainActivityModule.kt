package com.afkoders.batteryme.presentation

import android.content.Context
import com.afkoders.batteryme.di.qualifiers.ActivityContext
import com.afkoders.batteryme.di.scope.FragmentScope
import com.afkoders.batteryme.presentation.battery.BatteryAgreement
import com.afkoders.batteryme.presentation.battery.BatteryFragment
import com.afkoders.batteryme.presentation.battery.BatteryPresenter
import com.afkoders.batteryme.presentation.challenge_details.ChallengeDetailsAgreement
import com.afkoders.batteryme.presentation.challenge_details.ChallengeDetailsFragment
import com.afkoders.batteryme.presentation.challenge_details.ChallengeDetailsPresenter
import com.afkoders.batteryme.presentation.challenges.ChallengesAgreement
import com.afkoders.batteryme.presentation.challenges.ChallengesFragment
import com.afkoders.batteryme.presentation.challenges.ChallengesPresenter
import com.afkoders.batteryme.presentation.create_challenge.CreateChallengeAgreement
import com.afkoders.batteryme.presentation.create_challenge.CreateChallengeFragment
import com.afkoders.batteryme.presentation.create_challenge.CreateChallengePresenter
import com.afkoders.batteryme.presentation.create_event.CreateEventAgreement
import com.afkoders.batteryme.presentation.create_event.CreateEventFragment
import com.afkoders.batteryme.presentation.create_event.CreateEventPresenter
import com.afkoders.batteryme.presentation.event_details.EventDetailsAgreement
import com.afkoders.batteryme.presentation.event_details.EventDetailsFragment
import com.afkoders.batteryme.presentation.event_details.EventDetailsPresenter
import com.afkoders.batteryme.presentation.events.EventsAgreement
import com.afkoders.batteryme.presentation.events.EventsFragment
import com.afkoders.batteryme.presentation.events.EventsPresenter
import com.afkoders.batteryme.presentation.leaderboard.LeaderboardAgreement
import com.afkoders.batteryme.presentation.leaderboard.LeaderboardFragment
import com.afkoders.batteryme.presentation.leaderboard.LeaderboardPresenter
import com.afkoders.batteryme.presentation.login.LoginAgreement
import com.afkoders.batteryme.presentation.login.LoginFragment
import com.afkoders.batteryme.presentation.login.LoginPresenter
import com.afkoders.batteryme.presentation.logout.LogoutAgreement
import com.afkoders.batteryme.presentation.logout.LogoutPresenter
import com.afkoders.batteryme.presentation.splash.SplashAgreement
import com.afkoders.batteryme.presentation.splash.SplashFragment
import com.afkoders.batteryme.presentation.splash.SplashPresenter
import com.afkoders.batteryme.presentation.main.MainFragment
import com.afkoders.batteryme.presentation.main.MainFragmentAgreement
import com.afkoders.batteryme.presentation.main.MainFragmentPresenter
import com.afkoders.batteryme.presentation.quiz.PreQuizAgreement
import com.afkoders.batteryme.presentation.quiz.PreQuizFragment
import com.afkoders.batteryme.presentation.quiz.PreQuizPresenter
import com.afkoders.batteryme.presentation.logout.LogoutFragment
import com.afkoders.batteryme.presentation.quiz.q1.Quiz1Agreement
import com.afkoders.batteryme.presentation.quiz.q1.Quiz1Fragment
import com.afkoders.batteryme.presentation.quiz.q1.Quiz1Presenter
import com.afkoders.batteryme.presentation.quiz.q2.Quiz2Agreement
import com.afkoders.batteryme.presentation.quiz.q2.Quiz2Fragment
import com.afkoders.batteryme.presentation.quiz.q2.Quiz2Presenter
import com.afkoders.batteryme.presentation.quiz.q3.Quiz3Agreement
import com.afkoders.batteryme.presentation.quiz.q3.Quiz3Fragment
import com.afkoders.batteryme.presentation.quiz.q3.Quiz3Presenter
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

    @FragmentScope
    @ContributesAndroidInjector
    fun quizFragment(): PreQuizFragment?

    @FragmentScope
    @ContributesAndroidInjector
    fun quiz1Fragment(): Quiz1Fragment?

    @FragmentScope
    @ContributesAndroidInjector
    fun quiz2Fragment(): Quiz2Fragment?

    @FragmentScope
    @ContributesAndroidInjector
    fun quiz3Fragment(): Quiz3Fragment?

    @Binds
    fun testPresenter(testPresenter: TestPresenter): TestAgreement.Presenter

    @FragmentScope
    @ContributesAndroidInjector
    fun splashFragment(): SplashFragment?

    @Binds
    fun splashPresenter(splashPresenter: SplashPresenter): SplashAgreement.Presenter


    @FragmentScope
    @ContributesAndroidInjector
    fun logoutFragment(): LogoutFragment?

    @Binds
    fun logoutPresenter(logoutPresenter: LogoutPresenter): LogoutAgreement.Presenter


    @Binds
    fun loginPresenter(loginPresenter: LoginPresenter): LoginAgreement.Presenter

    @Binds
    fun quizPresenter(loginPresenter: PreQuizPresenter): PreQuizAgreement.Presenter

    @Binds
    fun quiz1Presenter(loginPresenter: Quiz1Presenter): Quiz1Agreement.Presenter

    @Binds
    fun quiz2Presenter(loginPresenter: Quiz2Presenter): Quiz2Agreement.Presenter

    @Binds
    fun quiz3Presenter(loginPresenter: Quiz3Presenter): Quiz3Agreement.Presenter

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

    @FragmentScope
    @ContributesAndroidInjector
    fun eventDetailFragment(): EventDetailsFragment?

    @Binds
    fun eventDetailsFragmentPresenter(eventDetailsFragment: EventDetailsPresenter): EventDetailsAgreement.Presenter

    @FragmentScope
    @ContributesAndroidInjector
    fun challengeDetailFragment(): ChallengeDetailsFragment?

    @Binds
    fun challengeDetailsFragmentPresenter(challengeDetailsFragment: ChallengeDetailsPresenter): ChallengeDetailsAgreement.Presenter

    @FragmentScope
    @ContributesAndroidInjector
    fun createChallengeFragment(): CreateChallengeFragment?

    @Binds
    fun createChallengeFragmentPresenter(createChallengePresenter: CreateChallengePresenter): CreateChallengeAgreement.Presenter

    @FragmentScope
    @ContributesAndroidInjector
    fun createEventFragment(): CreateEventFragment?

    @Binds
    fun createEventFragmentPresenter(createEventPresenter: CreateEventPresenter): CreateEventAgreement.Presenter

    @ActivityContext
    @Binds
    fun bindActivityContext(mainActivity: MainActivity): Context
}