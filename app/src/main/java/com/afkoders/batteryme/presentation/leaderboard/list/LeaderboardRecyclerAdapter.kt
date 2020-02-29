package com.afkoders.batteryme.presentation.leaderboard.list

import com.afkoders.batteryme.presentation.common.RecyclerDelegationAdapter
import com.afkoders.batteryme.presentation.common.delegates.EmptyItemAdapterDelegate
import com.afkoders.batteryme.presentation.common.delegates.HeaderAdapterDelegate
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import org.koin.standalone.KoinComponent
import javax.inject.Inject

class LeaderboardRecyclerAdapter(
    emptyItemAdapterDelegate: EmptyItemAdapterDelegate,
    leaderboardAdapterDelegate: LeaderboardAdapterDelegate,
    headerAdapterDelegate: HeaderAdapterDelegate
) :
    RecyclerDelegationAdapter<AdapterDelegateItem>(), KoinComponent {

    init {
        delegatesManager
            .addDelegate(leaderboardAdapterDelegate)
            .addDelegate(headerAdapterDelegate)
            .addDelegate(emptyItemAdapterDelegate)
    }
}