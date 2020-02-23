package com.afkoders.batteryme.presentation.events

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.data.repository.Repository
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.common.models.HeaderItem
import javax.inject.Inject

class EventsPresenter @Inject constructor(
    private val repository: Repository,
    private val appPrefs: AppPrefs
) :
    BasePresenterImpl<List<AdapterDelegateItem>, EventsAgreement.View>(),
    EventsAgreement.Presenter {

    override fun uploadData() {
        repository.getAllEvents { events ->
            val myEvents = events
                .filter { it.users.any { it.id == appPrefs.user.id } }.map {
                    AdapterDelegateItem.Model(
                        it
                    )
                }

            val allEvents = events
                .filter { it.users.none { it.id == appPrefs.user.id } }.map {
                    AdapterDelegateItem.Model(
                        it
                    )
                }

            val result = if (myEvents.isNotEmpty()) {
                mutableListOf(HeaderItem("My events")).plus(myEvents)
            } else {
                listOf()
            }.plus(
                if (allEvents.isNotEmpty()) {
                    mutableListOf(HeaderItem("All events")).plus(allEvents)
                } else {
                    listOf()
                }
            )

            model = result
            view?.populateData(result)
        }
    }

}