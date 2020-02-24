package com.afkoders.batteryme.presentation.challenges.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.challenges.model.Challenge
import com.afkoders.batteryme.presentation.common.models.User
import com.afkoders.batteryme.utils.extensions.dp
import com.afkoders.batteryme.utils.extensions.throttleFirst
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.item_event.view.*

class ChallengeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvEventName = itemView.tvTitle
    private val tvEventDescription = itemView.tvDescription
    private val ivEventBottom = itemView.ivBottomImage
    private val ivEventUpper = itemView.ivUpperImage
    private val tvCount = itemView.tvCount

    fun bindName(name: String?) {
        tvEventName.text = name ?: ""
    }

    fun bindDescription(description: String?) {
        tvEventDescription.text = description ?: ""
    }

    fun challengeClickedObservable(challenge: Challenge) =
        RxView.clicks(itemView)
            .throttleFirst()
            .map { challenge }

    fun bindUsers(users: List<User>) {

        val requestOptions = RequestOptions().apply {
            transform(CenterCrop(), RoundedCorners(16.dp(itemView.context)))
        }

        if(users.isNotEmpty()) {
            Glide.with(itemView.context).load(users.get(0).photo).apply(requestOptions)
                .placeholder(R.drawable.ic_placeholder_users).into(ivEventUpper)
        }
        if(users.size > 1) {
            Glide.with(itemView.context).load(users.get(1).photo).apply(requestOptions)
                .placeholder(R.drawable.ic_placeholder_users).into(ivEventBottom)
        }
        if(users.size > 3){
            ivEventBottom.visibility = View.GONE
            tvCount.visibility = View.VISIBLE
            tvCount.text = users.size.toString()

        }
    }
}