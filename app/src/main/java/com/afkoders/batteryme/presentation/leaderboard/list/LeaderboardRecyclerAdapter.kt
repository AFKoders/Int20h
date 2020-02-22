package com.afkoders.batteryme.presentation.leaderboard.list

import com.afkoders.batteryme.presentation.common.RecyclerDelegationAdapter
import com.afkoders.batteryme.presentation.common.delegates.EmptyItemAdapterDelegate
import com.afkoders.batteryme.presentation.common.delegates.HeaderAdapterDelegate
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import javax.inject.Inject

class LeaderboardRecyclerAdapter @Inject constructor(
    emptyItemAdapterDelegate: EmptyItemAdapterDelegate,
    leaderboardAdapterDelegate: LeaderboardAdapterDelegate,
    headerAdapterDelegate: HeaderAdapterDelegate
) :
    RecyclerDelegationAdapter<AdapterDelegateItem>() {

    init {
        delegatesManager
            .addDelegate(leaderboardAdapterDelegate)
            .addDelegate(headerAdapterDelegate)
            .addDelegate(emptyItemAdapterDelegate)
    }
}