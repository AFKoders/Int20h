package com.afkoders.batteryme.presentation.events

import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import javax.inject.Inject

class EventsPresenter @Inject constructor():
    BasePresenterImpl<Unit /* TODO change model here */, EventsAgreement.View>(),
    EventsAgreement.Presenter {

}