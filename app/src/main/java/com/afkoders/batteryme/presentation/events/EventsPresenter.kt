package com.afkoders.batteryme.presentation.events

import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.common.models.HeaderItem
import com.afkoders.batteryme.presentation.common.models.User
import com.afkoders.batteryme.presentation.events.model.Event
import java.util.*
import javax.inject.Inject

class EventsPresenter @Inject constructor() :
    BasePresenterImpl<List<AdapterDelegateItem>, EventsAgreement.View>(),
    EventsAgreement.Presenter {

    override fun uploadData() {
        // TODO fetch data from firebase
        val myEvents = listOf(
            Event("title1", "description1", Date(), "Kitchen", listOf()),
            Event(
                "title2",
                "description2",
                Date(),
                "Room1",
                listOf(
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null),
                    User("", "", "", "", "", null)
                )
            )
        )
        val allEvents = listOf(
            Event("title1", "description1", Date(), "Kitchen", listOf()),
            Event("title2", "description2", Date(), "Room1", listOf()),
            Event("title3", "description4", Date(), "Room3", listOf())
        )

        model = listOf(HeaderItem("My events"))
            .plus(myEvents.map { AdapterDelegateItem.Model(it) })
            .plus(HeaderItem("All events"))
            .plus(allEvents.map { AdapterDelegateItem.Model(it) })

        view?.populateData(model as List<AdapterDelegateItem>)
    }

}