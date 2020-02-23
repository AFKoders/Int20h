package com.afkoders.batteryme.presentation.create_event

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.events.model.Event

interface CreateEventAgreement {
    interface View: BaseView {
        fun showData(event: Event)
    }

    interface Presenter: BasePresenter<View> {
    }
}