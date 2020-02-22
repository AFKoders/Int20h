package com.afkoders.batteryme.presentation.login

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView

interface LoginAgreement {
    interface View: BaseView {

    }

    interface Presenter: BasePresenter<View> {

    }
}