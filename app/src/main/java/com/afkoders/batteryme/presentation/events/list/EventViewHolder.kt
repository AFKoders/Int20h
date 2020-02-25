package com.afkoders.batteryme.presentation.events.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.common.models.User
import com.afkoders.batteryme.presentation.events.model.Event
import com.afkoders.batteryme.utils.extensions.throttleFirst
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.item_event.view.*
import java.text.SimpleDateFormat
import java.util.*

class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvEventName = itemView.tvTitle
    private val tvEventDescription = itemView.tvDescription
    private val tvEventDate = itemView.tvDate
    private val tvEventTime = itemView.tvTime
    private val ivEventBottom = itemView.ivBottomImage
    private val ivEventUpper = itemView.ivUpperImage
    private val tvCount = itemView.tvCount

    fun bindName(name: String?) {
        tvEventName.text = name ?: ""
    }

    fun bindDescription(description: String?) {
        tvEventDescription.text = description ?: ""
    }

    fun bindTime(time: Date) {
        val calendar = Calendar.getInstance()
        calendar.time = time
        tvEventTime.text =
            calendar.get(Calendar.HOUR_OF_DAY).toString() + " : " + calendar.get(Calendar.MINUTE).toString()
        tvEventDate.text =
            calendar.get(Calendar.DAY_OF_MONTH).toString() + "\n" + SimpleDateFormat("MMM")
                .format(calendar.time)
    }

    fun bindUsers(
        users: List<User>,
        requestOptions: RequestOptions
    ) {
        if (users.isNotEmpty()) {
            Glide.with(itemView.context).load(users[0].photo)
                .apply(requestOptions)
                .placeholder(R.drawable.ic_placeholder_users).into(ivEventUpper)
        }

        if (users.size > 1) {
            Glide.with(itemView.context).load(users[1].photo)
                .apply(requestOptions)
                .placeholder(R.drawable.ic_placeholder_users).into(ivEventBottom)
        }

        if (users.size > 3) {
            ivEventBottom.visibility = View.GONE
            tvCount.visibility = View.VISIBLE
            tvCount.text = users.size.toString()
        }
    }

    fun eventClickedObservable(event: Event) =
        RxView.clicks(itemView)
            .throttleFirst()
            .map { event }

}