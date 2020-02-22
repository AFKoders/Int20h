package com.afkoders.batteryme.presentation.leaderboard

import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.events.EventsAgreement

class LeaderboardFragment :
    BaseFragmentImpl<LeaderboardAgreement.Presenter, LeaderboardAgreement.View>(R.layout.fragment_leaderboard),
    LeaderboardAgreement.View {
    override fun setupInputs() {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun returnThisHerePlease(): LeaderboardAgreement.View = this
}