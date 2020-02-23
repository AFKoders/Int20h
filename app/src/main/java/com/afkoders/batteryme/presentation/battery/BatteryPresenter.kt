package com.afkoders.batteryme.presentation.battery

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.data.repository.Repository
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.common.models.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class BatteryPresenter @Inject constructor(
    private val appPrefs: AppPrefs,
    private val repository: Repository
) :
    BasePresenterImpl<String, BatteryAgreement.View>(),
    BatteryAgreement.Presenter {


    override fun askPercentage() {
        view?.setPercentage(appPrefs.user.score)
    }

    override fun startTimer() {
        var user: User? = null
        Observable.interval(5, TimeUnit.SECONDS, Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ tick ->
               var user =  appPrefs.user
                if(user.score > 10) {
                    user.score = user.score - 1
                    repository.addUserRemote(user)
                    appPrefs.user = user
                    askPercentage()
                }
            }, { throwable ->
                // handle error
            })
    }
}