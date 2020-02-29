package com.afkoders.batteryme.presentation.logout

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class LogoutPresenter(private val appPrefs: AppPrefs) :
    BasePresenterImpl<String, LogoutAgreement.View>(),
    LogoutAgreement.Presenter {
    override fun fire() {
        Observable.just(Any())
            .delay(1, TimeUnit.SECONDS)
            .doOnNext { appPrefs.clear() }
            .subscribe {
                view?.redirect()
            }
    }
}