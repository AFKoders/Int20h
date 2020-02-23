package com.afkoders.batteryme.presentation.battery

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.data.repository.Repository
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
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

    override fun getPercentage(): Int {
        return appPrefs.user.score
    }
}