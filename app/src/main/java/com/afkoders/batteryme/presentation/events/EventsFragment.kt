package com.afkoders.batteryme.presentation.events

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.events.list.EventsRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_events.*
import javax.inject.Inject

class EventsFragment :
    BaseFragmentImpl<EventsAgreement.Presenter, EventsAgreement.View>(R.layout.fragment_events),
    EventsAgreement.View {

    @Inject lateinit var adapter: EventsRecyclerAdapter

    override fun setupInputs() {
        rvEvents.itemAnimator = DefaultItemAnimator()
        rvEvents.adapter = adapter
        rvEvents.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0 && fabNewEvent.isShown) {
                    fabNewEvent.hide()
                } else if (dy < 0) {
                    fabNewEvent.show()
                }
            }
        })

        adapter.eventClickedObservable
            .subscribe {
                // TODO open details screen
            }.disposeByBagProvider()
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun populateData(data: List<AdapterDelegateItem>) {
        adapter.clearAndAddAll(data)
    }

    override fun returnThisHerePlease(): EventsAgreement.View = this
}