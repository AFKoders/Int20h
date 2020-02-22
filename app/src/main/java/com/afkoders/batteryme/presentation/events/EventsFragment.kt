package com.afkoders.batteryme.presentation.events

import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl

class EventsFragment :
    BaseFragmentImpl<EventsAgreement.Presenter, EventsAgreement.View>(R.layout.fragment_events),
    EventsAgreement.View {
    override fun setupInputs() {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun returnThisHerePlease(): EventsAgreement.View = this
}