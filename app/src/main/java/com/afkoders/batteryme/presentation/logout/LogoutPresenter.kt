package com.afkoders.batteryme.presentation.logout

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.common.models.User
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class LogoutPresenter @Inject constructor(private val appPrefs: AppPrefs) :
    BasePresenterImpl<String, LogoutAgreement.View>(),
    LogoutAgreement.Presenter {
    override fun fire() {
        Observable.just(Any())
            .delay(1, TimeUnit.SECONDS)
            .subscribe {
                view?.redirect()
            }
    }
}