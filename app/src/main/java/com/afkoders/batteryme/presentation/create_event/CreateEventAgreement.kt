package com.afkoders.batteryme.presentation.create_event

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView
import java.util.*

interface CreateEventAgreement {
    interface View: BaseView {
        fun eventCreated()
    }

    interface Presenter: BasePresenter<View> {
        fun createEvent(title: String, description: String, location: String, date: Date)
    }
}