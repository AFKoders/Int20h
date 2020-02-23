package com.afkoders.batteryme.presentation.create_event

import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.events.EventsAgreement

class CreateEventFragment :
    BaseFragmentImpl<CreateEventAgreement.Presenter, CreateEventAgreement.View>(R.layout.fragment_events),
    CreateEventAgreement.View {
