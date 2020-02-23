package com.afkoders.batteryme.presentation.logout

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView

interface LogoutAgreement {
    interface View : BaseView {
        fun redirect()
    }

    interface Presenter : BasePresenter<View> {

        fun fire()
    }
}