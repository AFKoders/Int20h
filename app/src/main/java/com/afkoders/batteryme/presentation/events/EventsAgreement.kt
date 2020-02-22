package com.afkoders.batteryme.presentation.events

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.events.model.Event

interface EventsAgreement {
    interface View: BaseView {
        fun populateData(data: List<AdapterDelegateItem>)
    }

    interface Presenter: BasePresenter<View> {
        fun uploadData()
    }
}