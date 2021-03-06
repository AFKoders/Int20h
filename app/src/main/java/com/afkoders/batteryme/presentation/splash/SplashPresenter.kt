package com.afkoders.batteryme.presentation.splash

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.common.models.User
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashPresenter @Inject constructor(private val appPrefs: AppPrefs) :
    BasePresenterImpl<String, SplashAgreement.View>(),
    SplashAgreement.Presenter {
    override fun fire() {
        Observable.just(Any())
            .subscribe {
                view?.redirect()
            }
    }
}