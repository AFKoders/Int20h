package com.afkoders.batteryme.presentation.events

import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl

class EventsFragment :
    BaseFragmentImpl<EventsAgreement.Presenter, EventsAgreement.View>(R.layout.fragment_events),
    EventsAgreement.View {
    override fun setupInputs() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun returnThisHerePlease(): EventsAgreement.View = this
}