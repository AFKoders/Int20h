package com.afkoders.batteryme.presentation.event_details

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView
import com.afkoders.batteryme.presentation.events.model.Event

interface EventDetailsAgreement {
    interface View: BaseView {
        fun showData(event: Event)
        fun joinedToEvent()
        fun leavedFromEvent()
        fun initButton(isJoined: Boolean)
        fun finishScreen()
    }

    interface Presenter: BasePresenter<View> {
        fun joinToEvent()
        fun leaveFromEvent()
        fun setModel(event: Event)
    }
}