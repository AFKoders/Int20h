package com.afkoders.batteryme.presentation.challenges.list

import com.afkoders.batteryme.presentation.challenges.list.ChallengeAdapterDelegate
import com.afkoders.batteryme.presentation.common.RecyclerDelegationAdapter
import com.afkoders.batteryme.presentation.common.delegates.EmptyItemAdapterDelegate
import com.afkoders.batteryme.presentation.common.delegates.HeaderAdapterDelegate
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import javax.inject.Inject

class ChallengeRecyclerAdapter @Inject constructor(
    emptyItemAdapterDelegate: EmptyItemAdapterDelegate,
    challengeAdapterDelegate: ChallengeAdapterDelegate,
    headerAdapterDelegate: HeaderAdapterDelegate
) :
    RecyclerDelegationAdapter<AdapterDelegateItem>() {

    val challengeClickedObservable = challengeAdapterDelegate.challengeClickedSubject

    init {
        delegatesManager
            .addDelegate(challengeAdapterDelegate)
            .addDelegate(headerAdapterDelegate)
            .addDelegate(emptyItemAdapterDelegate)
    }
}