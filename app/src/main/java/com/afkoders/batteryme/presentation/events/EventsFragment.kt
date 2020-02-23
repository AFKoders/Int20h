package com.afkoders.batteryme.presentation.events

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.events.list.EventsRecyclerAdapter
import com.afkoders.batteryme.presentation.main.MainFragment
import com.afkoders.batteryme.utils.extensions.show
import com.afkoders.batteryme.utils.extensions.widget.makeGone
import com.afkoders.batteryme.utils.extensions.widget.makeVisible
import kotlinx.android.synthetic.main.fragment_events.*
import javax.inject.Inject

class EventsFragment :
    BaseFragmentImpl<EventsAgreement.Presenter, EventsAgreement.View>(R.layout.fragment_events),
    EventsAgreement.View {

    @Inject
    lateinit var adapter: EventsRecyclerAdapter

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

        swipeRefreshLayoutEvents.setOnRefreshListener {
            presenter.uploadData()
        }

        adapter.eventClickedObservable
            .subscribe {
                (parentFragment as MainFragment).navigateToEventDetailsFragment(it)
            }.disposeByBagProvider()

        fabNewEvent.bindClick {
            (parentFragment as MainFragment).navigateToEventCreation()
        }

    }

    override fun onResume() {
        super.onResume()
        presenter.uploadData()
    }

    override fun showLoading() {
        swipeRefreshLayoutEvents.makeGone()
        progress.show(parentFragmentManager)
    }

    override fun hideLoading() {
        progress.dismiss()
        swipeRefreshLayoutEvents.makeVisible()
    }

    override fun populateData(data: List<AdapterDelegateItem>) {
        swipeRefreshLayoutEvents.isRefreshing = false
        adapter.clearAndAddAll(data)
    }

    override fun returnThisHerePlease(): EventsAgreement.View = this
}