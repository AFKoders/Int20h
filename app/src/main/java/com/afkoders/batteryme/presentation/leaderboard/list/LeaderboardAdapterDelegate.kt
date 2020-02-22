package com.afkoders.batteryme.presentation.leaderboard.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.leaderboard.list.LeaderboardViewHolder
import com.afkoders.batteryme.presentation.leaderboard.model.LeaderboardModel
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class LeaderboardAdapterDelegate @Inject constructor() : AdapterDelegate<MutableList<@kotlin.jvm.JvmSuppressWildcards AdapterDelegateItem>>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val context = parent.context
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_leaderboard, parent, false)
        return LeaderboardViewHolder(itemView)
    }

    override fun isForViewType(items: MutableList<AdapterDelegateItem>, position: Int): Boolean {
        val item = items[position]
        return item is AdapterDelegateItem.Model<*>
    }

    override fun onBindViewHolder(items: MutableList<AdapterDelegateItem>, position: Int,
                                  holder: RecyclerView.ViewHolder, payloads: MutableList<Any>) {
        val model = (items[position] as AdapterDelegateItem.Model<*>).model as LeaderboardModel?
        if (holder is LeaderboardViewHolder && model != null) {
            holder.bindName(model.name)
            holder.bindPhoto(model.photoUrl)
            holder.bindScore(model.score)
        }
    }
}