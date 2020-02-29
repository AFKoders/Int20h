package com.afkoders.batteryme.presentation.splash

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import io.reactivex.Observable

class SplashPresenter(private val appPrefs: AppPrefs) :
    BasePresenterImpl<String, SplashAgreement.View>(),
    SplashAgreement.Presenter {
    override fun fire() {
        Observable.just(Any())
            .subscribe {
                view?.redirect()
            }
    }
}