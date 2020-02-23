package com.afkoders.batteryme.presentation.create_event

import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.events.EventsAgreement
import com.afkoders.batteryme.presentation.events.model.Event

class CreateEventFragment :
    BaseFragmentImpl<CreateEventAgreement.Presenter, CreateEventAgreement.View>(R.layout.fragment_events),
    CreateEventAgreement.View {
    override fun setupInputs() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun returnThisHerePlease(): CreateEventAgreement.View {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showData(event: Event) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
