package com.afkoders.batteryme.presentation.battery

import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import javax.inject.Inject

class BatteryPresenter @Inject constructor():
    BasePresenterImpl<Unit /* TODO change model here */, BatteryAgreement.View>(),
    BatteryAgreement.Presenter {

}