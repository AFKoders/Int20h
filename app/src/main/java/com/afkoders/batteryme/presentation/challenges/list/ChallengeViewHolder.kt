package com.afkoders.batteryme.presentation.challenges.list

import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.afkoders.batteryme.presentation.challenges.model.Challenge
import com.afkoders.batteryme.presentation.common.models.User
import com.afkoders.batteryme.presentation.events.model.Event
import com.afkoders.batteryme.utils.extensions.format
import com.afkoders.batteryme.utils.extensions.throttleFirst
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.item_event.view.*
import java.util.*

class ChallengeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvEventName = itemView.tvTitle
    private val tvEventDescription = itemView.tvDescription

    fun bindName(name: String?) {
        tvEventName.text = name ?: ""
    }

    fun bindDescription(description: String?) {
        tvEventDescription.text = description ?: ""
    }

    fun bindUsers(users: List<User>) {
        // TODO add users somehow
    }

    fun challengeClickedObservable(challenge: Challenge) =
        RxView.clicks(itemView)
            .throttleFirst()
            .map { challenge }

}