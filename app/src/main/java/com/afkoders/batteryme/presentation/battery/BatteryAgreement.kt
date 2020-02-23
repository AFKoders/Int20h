package com.afkoders.batteryme.presentation.battery

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView

interface BatteryAgreement {
    interface View : BaseView {
        fun setPercentage(percents: Int)
    }

    interface Presenter : BasePresenter<View> {
       fun askPercentage()
        fun getPercentage(): Int

        fun startTimer()
    }
}