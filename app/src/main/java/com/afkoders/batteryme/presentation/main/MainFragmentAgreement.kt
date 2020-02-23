package com.afkoders.batteryme.presentation.main

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView

interface MainFragmentAgreement {
    interface View : BaseView {

    }

    interface Presenter : BasePresenter<View> {
    }
}