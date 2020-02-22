package com.afkoders.batteryme.presentation.splash

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView

interface SplashAgreement {
    interface View : BaseView {
        fun redirect()
    }

    interface Presenter : BasePresenter<View> {

        fun fire()
    }
}