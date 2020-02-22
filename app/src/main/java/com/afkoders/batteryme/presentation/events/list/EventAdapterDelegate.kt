package com.afkoders.batteryme.presentation.events.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.events.model.Event
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class EventAdapterDelegate @Inject constructor() :
    AdapterDelegate<MutableList<@kotlin.jvm.JvmSuppressWildcards AdapterDelegateItem>>() {
    val eventClickedSubject = PublishSubject.create<Event>()

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val context = parent.context
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.item_event, parent, false)
        return EventViewHolder(itemView)
    }

    override fun isForViewType(items: MutableList<AdapterDelegateItem>, position: Int): Boolean {
        val item = items[position]
        return item is AdapterDelegateItem.Model<*>
    }

    override fun onBindViewHolder(
        items: MutableList<AdapterDelegateItem>, position: Int,
        holder: RecyclerView.ViewHolder, payloads: MutableList<Any>
    ) {
        val event = (items[position] as AdapterDelegateItem.Model<*>).model as Event?
        if (holder is EventViewHolder && event != null) {
            holder.eventClickedObservable(event).subscribe(eventClickedSubject)
            holder.bindName(event.title)
            holder.bindDescription(event.description)
            holder.bindTime(event.dateTime)
            holder.bindUsers(event.users)
        }
    }
}