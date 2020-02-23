package com.afkoders.batteryme.presentation.quiz

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class QuizFinishPresenter @Inject constructor(private val appPrefs: AppPrefs) :
    BasePresenterImpl<String, QuizFinishAgreement.View>(),
    QuizFinishAgreement.Presenter {
    override fun fire() {
        Observable.just(Any())
            .delay(1, TimeUnit.SECONDS)
            .subscribe {
                appPrefs.setUserPassedQuiz(true)
                view?.redirect()
            }.disposeByBagProvider()
    }
}