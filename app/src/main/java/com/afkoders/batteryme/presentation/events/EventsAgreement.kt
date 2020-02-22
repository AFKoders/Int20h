package com.afkoders.batteryme.presentation.events

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView

interface EventsAgreement {
    interface View: BaseView {

    }

    interface Presenter: BasePresenter<View> {

    }
}