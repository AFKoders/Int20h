package com.afkoders.batteryme.presentation.events.list

import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.afkoders.batteryme.presentation.common.models.User
import com.afkoders.batteryme.presentation.events.model.Event
import com.afkoders.batteryme.utils.extensions.format
import com.afkoders.batteryme.utils.extensions.throttleFirst
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.item_event.view.*
import java.util.*

class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvEventName = itemView.tvTitle
    private val tvEventDescription = itemView.tvDescription
    private val tvEventTime = itemView.tvDateTime
    private val tvEventLocation = itemView.tvLocation

    fun bindName(name: String?) {
        tvEventName.text = name ?: ""
    }

    fun bindDescription(description: String?) {
        tvEventDescription.text = description ?: ""
    }

    fun bindTime(time: Date) {
        tvEventTime.text = time.format()
    }

    fun bindLocation(location: String?) {
        tvEventLocation.text = location ?: ""
    }

    fun bindUsers(users: List<User>) {
        // TODO add users somehow
    }

    fun eventClickedObservable(event: Event) =
        RxView.clicks(itemView)
            .throttleFirst()
            .map { event }

}