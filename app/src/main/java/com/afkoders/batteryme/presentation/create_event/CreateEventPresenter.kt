package com.afkoders.batteryme.presentation.create_event

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.events.model.Event
import java.util.*
import javax.inject.Inject

class CreateEventPresenter @Inject constructor(private val appPrefs: AppPrefs) :
    BasePresenterImpl<Event, CreateEventAgreement.View>(),
    CreateEventAgreement.Presenter {

    override fun createEvent(title: String, description: String, location: String, date: Date) {
        // TODO zayzat Sashkina xernya
        view?.eventCreated()
    }
}