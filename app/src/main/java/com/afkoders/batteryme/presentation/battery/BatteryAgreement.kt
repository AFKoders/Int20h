package com.afkoders.batteryme.presentation.battery

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView

interface BatteryAgreement {
    interface View: BaseView {

    }

    interface Presenter: BasePresenter<View> {

    }
}