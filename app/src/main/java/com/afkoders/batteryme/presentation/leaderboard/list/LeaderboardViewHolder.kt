package com.afkoders.batteryme.presentation.leaderboard.list

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
import com.afkoders.batteryme.presentation.leaderboard.model.LeaderboardModel
import com.afkoders.batteryme.utils.extensions.format
import com.afkoders.batteryme.utils.extensions.throttleFirst
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.item_event.view.*
import kotlinx.android.synthetic.main.item_leaderboard.view.*
import java.util.*

class LeaderboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val viewName = itemView.viewName
    private val viewPhoto = itemView.viewPhoto
    private val viewScore = itemView.viewScore

    fun bindName(name: String?) {
        viewName.text = name ?: ""
    }

    fun bindPhoto(imageUrl: String?) {
        Glide.with(itemView.context).load(imageUrl).into(viewPhoto)    }

    fun bindScore(score: Int) {
        viewScore.text = score.toString()
    }

    fun smthClickedObservable(data: LeaderboardModel) =
        RxView.clicks(itemView)
            .throttleFirst()
            .map { data }

}