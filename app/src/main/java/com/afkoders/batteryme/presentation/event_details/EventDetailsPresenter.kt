package com.afkoders.batteryme.presentation.event_details

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.events.model.Event
import javax.inject.Inject

class EventDetailsPresenter @Inject constructor(private val appPrefs: AppPrefs) :
    BasePresenterImpl<Event, EventDetailsAgreement.View>(),
    EventDetailsAgreement.Presenter {
    override fun joinToEvent() {
        // TODO
    }

    override fun leaveFromEvent() {
        // TODO
    }

    override fun setModel(event: Event) {
        model = event
        view?.initButton(event.users.contains(appPrefs.user))
        view?.showData(event)
    }

}