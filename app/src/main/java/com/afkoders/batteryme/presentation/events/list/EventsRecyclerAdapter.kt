package com.afkoders.batteryme.presentation.events.list

import com.afkoders.batteryme.presentation.common.RecyclerDelegationAdapter
import com.afkoders.batteryme.presentation.common.delegates.EmptyItemAdapterDelegate
import com.afkoders.batteryme.presentation.common.delegates.HeaderAdapterDelegate
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import javax.inject.Inject

class EventsRecyclerAdapter @Inject constructor(
    emptyItemAdapterDelegate: EmptyItemAdapterDelegate,
    eventAdapterDelegate: EventAdapterDelegate,
    headerAdapterDelegate: HeaderAdapterDelegate
) :
    RecyclerDelegationAdapter<AdapterDelegateItem>() {

    val eventClickedObservable = eventAdapterDelegate.eventClickedSubject

    init {
        delegatesManager
            .addDelegate(eventAdapterDelegate)
            .addDelegate(headerAdapterDelegate)
            .addDelegate(emptyItemAdapterDelegate)
    }
}