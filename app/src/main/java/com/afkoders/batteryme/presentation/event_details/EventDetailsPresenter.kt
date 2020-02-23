package com.afkoders.batteryme.presentation.event_details

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.data.repository.Repository
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.events.model.Event
import javax.inject.Inject

class EventDetailsPresenter @Inject constructor(private val appPrefs: AppPrefs,
                                                private val repository: Repository) :
    BasePresenterImpl<Event, EventDetailsAgreement.View>(),
    EventDetailsAgreement.Presenter {
    override fun joinToEvent() {
        repository.addUserToEvent(appPrefs.user, model!!.id)
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