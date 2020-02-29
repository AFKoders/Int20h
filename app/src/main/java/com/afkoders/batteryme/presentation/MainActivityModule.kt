package com.afkoders.batteryme.presentation

import android.content.Context
import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.data.repository.Repository
import com.afkoders.batteryme.di.qualifiers.ActivityContext
import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.base.BaseView
import com.afkoders.batteryme.presentation.battery.BatteryAgreement
import com.afkoders.batteryme.presentation.battery.BatteryPresenter
import com.afkoders.batteryme.presentation.challenge_details.ChallengeDetailsAgreement
import com.afkoders.batteryme.presentation.challenge_details.ChallengeDetailsPresenter
import com.afkoders.batteryme.presentation.challenges.ChallengesAgreement
import com.afkoders.batteryme.presentation.challenges.ChallengesPresenter
import com.afkoders.batteryme.presentation.challenges.list.ChallengeAdapterDelegate
import com.afkoders.batteryme.presentation.challenges.list.ChallengeRecyclerAdapter
import com.afkoders.batteryme.presentation.common.delegates.EmptyItemAdapterDelegate
import com.afkoders.batteryme.presentation.common.delegates.HeaderAdapterDelegate
import com.afkoders.batteryme.presentation.create_challenge.CreateChallengeAgreement
import com.afkoders.batteryme.presentation.create_challenge.CreateChallengePresenter
import com.afkoders.batteryme.presentation.create_event.CreateEventAgreement
import com.afkoders.batteryme.presentation.create_event.CreateEventPresenter
import com.afkoders.batteryme.presentation.event_details.EventDetailsAgreement
import com.afkoders.batteryme.presentation.event_details.EventDetailsPresenter
import com.afkoders.batteryme.presentation.events.EventsAgreement
import com.afkoders.batteryme.presentation.events.EventsPresenter
import com.afkoders.batteryme.presentation.events.list.EventAdapterDelegate
import com.afkoders.batteryme.presentation.events.list.EventsRecyclerAdapter
import com.afkoders.batteryme.presentation.leaderboard.LeaderboardAgreement
import com.afkoders.batteryme.presentation.leaderboard.LeaderboardPresenter
import com.afkoders.batteryme.presentation.leaderboard.list.LeaderboardAdapterDelegate
import com.afkoders.batteryme.presentation.leaderboard.list.LeaderboardRecyclerAdapter
import com.afkoders.batteryme.presentation.login.LoginAgreement
import com.afkoders.batteryme.presentation.login.LoginPresenter
import com.afkoders.batteryme.presentation.logout.LogoutAgreement
import com.afkoders.batteryme.presentation.logout.LogoutPresenter
import com.afkoders.batteryme.presentation.main.MainFragmentAgreement
import com.afkoders.batteryme.presentation.main.MainFragmentPresenter
import com.afkoders.batteryme.presentation.quiz.PreQuizAgreement
import com.afkoders.batteryme.presentation.quiz.PreQuizPresenter
import com.afkoders.batteryme.presentation.quiz.QuizFinishAgreement
import com.afkoders.batteryme.presentation.quiz.QuizFinishPresenter
import com.afkoders.batteryme.presentation.quiz.q1.Quiz1Agreement
import com.afkoders.batteryme.presentation.quiz.q1.Quiz1Presenter
import com.afkoders.batteryme.presentation.quiz.q2.Quiz2Agreement
import com.afkoders.batteryme.presentation.quiz.q2.Quiz2Presenter
import com.afkoders.batteryme.presentation.quiz.q3.Quiz3Agreement
import com.afkoders.batteryme.presentation.quiz.q3.Quiz3Presenter
import com.afkoders.batteryme.presentation.quiz.q4.Quiz4Agreement
import com.afkoders.batteryme.presentation.quiz.q4.Quiz4Presenter
import com.afkoders.batteryme.presentation.quiz.q5.Quiz5Agreement
import com.afkoders.batteryme.presentation.quiz.q5.Quiz5Presenter
import com.afkoders.batteryme.presentation.splash.SplashAgreement
import com.afkoders.batteryme.presentation.splash.SplashPresenter
import com.afkoders.batteryme.presentation.test.TestAgreement
import com.afkoders.batteryme.presentation.test.TestPresenter
import dagger.Binds
import dagger.Module
import org.koin.dsl.module.module


val mainActivityModule = module {
    single {
        TestPresenter(
            get(scopeId = "applicationScope") as Repository
        ) as TestAgreement.Presenter
    }

    single {
        SplashPresenter(
            get(scopeId = "applicationScope") as AppPrefs
        ) as SplashAgreement.Presenter
    }

    single {
        LogoutPresenter(
            get(scopeId = "applicationScope") as AppPrefs
        ) as LogoutAgreement.Presenter
    }

    single {
        LoginPresenter(
            get(scopeId = "applicationScope") as AppPrefs,
            get(scopeId = "applicationScope") as Repository
        ) as LoginAgreement.Presenter
    }

    single {
        PreQuizPresenter(
            get(scopeId = "applicationScope") as AppPrefs
        ) as PreQuizAgreement.Presenter
    }
    single {
        Quiz1Presenter(
            get(scopeId = "applicationScope") as AppPrefs
        ) as Quiz1Agreement.Presenter
    }
    single {
        Quiz2Presenter(
            get(scopeId = "applicationScope") as AppPrefs
        ) as Quiz2Agreement.Presenter
    }
    single {
        Quiz3Presenter(
            get(scopeId = "applicationScope") as AppPrefs
        ) as Quiz3Agreement.Presenter
    }
    single {
        Quiz4Presenter(
            get(scopeId = "applicationScope") as AppPrefs
        ) as Quiz4Agreement.Presenter
    }
    single {
        Quiz5Presenter(
            get(scopeId = "applicationScope") as AppPrefs
        ) as Quiz5Agreement.Presenter
    }
    single {
        QuizFinishPresenter(
            get(scopeId = "applicationScope") as AppPrefs
        ) as QuizFinishAgreement.Presenter
    }

    single {
        CreateEventPresenter(
            get(scopeId = "applicationScope") as AppPrefs,
            get(scopeId = "applicationScope") as Repository
        ) as CreateEventAgreement.Presenter
    }
    single {
        CreateChallengePresenter(
            get(scopeId = "applicationScope") as AppPrefs,
            get(scopeId = "applicationScope") as Repository
        ) as CreateChallengeAgreement.Presenter
    }
    single {
        ChallengeDetailsPresenter(
            get(scopeId = "applicationScope") as AppPrefs,
            get(scopeId = "applicationScope") as Repository
        ) as ChallengeDetailsAgreement.Presenter
    }
    single {
        EventDetailsPresenter(
            get(scopeId = "applicationScope") as AppPrefs,
            get(scopeId = "applicationScope") as Repository
        ) as EventDetailsAgreement.Presenter
    }
    single {
        LeaderboardPresenter(
            get(scopeId = "applicationScope") as Repository
        ) as LeaderboardAgreement.Presenter
    }
    single {
        ChallengesPresenter(
            get(scopeId = "applicationScope") as Repository,
            get(scopeId = "applicationScope") as AppPrefs
        ) as ChallengesAgreement.Presenter
    }

    single {
        EventsPresenter(
            get(scopeId = "applicationScope") as Repository,
            get(scopeId = "applicationScope") as AppPrefs
        ) as EventsAgreement.Presenter
    }

    single {
        BatteryPresenter(
            get(scopeId = "applicationScope") as AppPrefs,
            get(scopeId = "applicationScope") as Repository
        ) as BatteryAgreement.Presenter
    }

    single {
        MainFragmentPresenter() as MainFragmentAgreement.Presenter
    }

    single {
        LeaderboardRecyclerAdapter(
            get() as EmptyItemAdapterDelegate,
            get() as LeaderboardAdapterDelegate,
            get() as HeaderAdapterDelegate
        )
    }
    single {
        EventsRecyclerAdapter(
            get() as EmptyItemAdapterDelegate,
            get() as EventAdapterDelegate,
            get() as HeaderAdapterDelegate
        )
    }

    single {
        ChallengeRecyclerAdapter(
            get() as EmptyItemAdapterDelegate,
            get() as ChallengeAdapterDelegate,
            get() as HeaderAdapterDelegate
        )
    }

    single {
        EmptyItemAdapterDelegate()
    }
    single {
        LeaderboardAdapterDelegate()
    }
    single {
        EventAdapterDelegate()
    }
    single {
        ChallengeAdapterDelegate()
    }
    single {
        HeaderAdapterDelegate()
    }

}

@Module
interface MainActivityModule {
    @Binds
    fun leaderboardFragmentPresenter(leaderboardFragmentPresenter: LeaderboardPresenter): LeaderboardAgreement.Presenter

    @Binds
    fun eventDetailsFragmentPresenter(eventDetailsFragment: EventDetailsPresenter): EventDetailsAgreement.Presenter

    @Binds
    fun challengeDetailsFragmentPresenter(challengeDetailsFragment: ChallengeDetailsPresenter): ChallengeDetailsAgreement.Presenter

    @Binds
    fun createChallengeFragmentPresenter(createChallengePresenter: CreateChallengePresenter): CreateChallengeAgreement.Presenter

    @Binds
    fun createEventFragmentPresenter(createEventPresenter: CreateEventPresenter): CreateEventAgreement.Presenter

    @ActivityContext
    @Binds
    fun bindActivityContext(mainActivity: MainActivity): Context
}