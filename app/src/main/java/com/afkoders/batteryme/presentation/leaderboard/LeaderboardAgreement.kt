package com.afkoders.batteryme.presentation.leaderboard

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate

interface LeaderboardAgreement {
    interface View: BaseView {
        fun populateData(data: List<AdapterDelegateItem>)
    }

    interface Presenter: BasePresenter<View> {
        fun uploadData()
    }
}