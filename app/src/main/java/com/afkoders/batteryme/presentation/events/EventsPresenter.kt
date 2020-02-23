package com.afkoders.batteryme.presentation.events

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.data.repository.Repository
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.common.models.HeaderItem
import javax.inject.Inject

class EventsPresenter @Inject constructor(private val repository: Repository, private val appPrefs: AppPrefs) :
    BasePresenterImpl<List<AdapterDelegateItem>, EventsAgreement.View>(),
    EventsAgreement.Presenter {

    override fun uploadData() {
        // TODO fetch data from firebase
        /* val myEvents = listOf(
             Event("title1", "description1", Date(), "Kitchen", mutableListOf()),
             Event(
                 "title2",
                 "description2",
                 Date(),
                 "Room1",
                 mutableListOf(
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", ""),
                     User("", "", "", "", "", "")
                 )
             )
         )
         val allEvents = listOf(
             Event("title1", "description1", Date(), "Kitchen", mutableListOf()),
             Event("title2", "description2", Date(), "Room1", mutableListOf()),
             Event("title3", "description4", Date(), "Room3", mutableListOf())
         )

         model = listOf(HeaderItem("My events"))
             .plus(myEvents.map { AdapterDelegateItem.Model(it) })
             .plus(HeaderItem("All events"))
             .plus(allEvents.map { AdapterDelegateItem.Model(it) })

         view?.populateData(model as List<AdapterDelegateItem>) */

        repository.getAllEvents { events ->
            view?.populateData(mutableListOf(HeaderItem("My events"))
                .plus(events
                    .filter { it.users.any { it.id == appPrefs.user.id } }.map {
                        AdapterDelegateItem.Model(
                            it
                        )
                    }).plus(mutableListOf(HeaderItem("All events")).plus(events
                    .filter { it.users.none { it.id == appPrefs.user.id } }.map {
                        AdapterDelegateItem.Model(
                            it
                        )
                    })
                )
            )
        }
    }

}