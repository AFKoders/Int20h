package com.afkoders.batteryme.presentation.leaderboard.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.afkoders.batteryme.R
import com.afkoders.batteryme.utils.extensions.dp
import com.bumptech.glide.Glide
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
            transform(CenterCrop(), RoundedCorners(16.dp(itemView.context)))
        }

        Glide.with(itemView.context)
            .load(imageUrl)
            .apply(requestOptions)
            .placeholder(R.drawable.ic_placeholder_users)
            .into(viewPhoto)
    }

    fun bindScore(score: Int) {
        viewScore.setProgress(score)
    }
}