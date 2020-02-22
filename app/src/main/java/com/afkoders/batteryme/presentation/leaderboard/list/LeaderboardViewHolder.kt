package com.afkoders.batteryme.presentation.leaderboard.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.afkoders.batteryme.presentation.leaderboard.model.LeaderboardModel
import com.afkoders.batteryme.utils.extensions.throttleFirst
import com.bumptech.glide.Glide
import com.jakewharton.rxbinding2.view.RxView
import kotlinx.android.synthetic.main.item_leaderboard.view.*
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions



class LeaderboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val viewName = itemView.tvName
    private val viewPhoto = itemView.ivPhoto
    private val viewScore = itemView.batteryView

    fun bindName(name: String?) {
        viewName.text = name ?: ""
    }

    fun bindPhoto(imageUrl: String?) {
        val requestOptions = RequestOptions().apply {
            transform(CenterCrop(), RoundedCorners(16))
        }

        Glide.with(itemView.context)
            .load("https://source.unsplash.com/random")
           // .apply(requestOptions)
            .into(viewPhoto)
    }

    fun bindScore(score: Int) {
        viewScore.update(score)
    }
}