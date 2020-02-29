package com.afkoders.batteryme.presentation.challenges.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.challenges.model.Challenge
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class ChallengeAdapterDelegate : AdapterDelegate<MutableList<@kotlin.jvm.JvmSuppressWildcards AdapterDelegateItem>>() {
    val challengeClickedSubject = PublishSubject.create<Challenge>()

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val context = parent.context
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.item_challenge, parent, false)
        return ChallengeViewHolder(itemView)
    }

    override fun isForViewType(items: MutableList<AdapterDelegateItem>, position: Int): Boolean {
        val item = items[position]
        return item is AdapterDelegateItem.Model<*>
    }

    override fun onBindViewHolder(items: MutableList<AdapterDelegateItem>, position: Int,
                                  holder: RecyclerView.ViewHolder, payloads: MutableList<Any>) {
        val challenge = (items[position] as AdapterDelegateItem.Model<*>).model as Challenge?
        if (holder is ChallengeViewHolder && challenge != null) {
            holder.challengeClickedObservable(challenge).subscribe(challengeClickedSubject)
            holder.bindName(challenge.title)
            holder.bindDescription(challenge.description)
            holder.bindUsers(challenge.users)
        }
    }
}