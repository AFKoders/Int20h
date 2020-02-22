package com.afkoders.batteryme.presentation.leaderboard

import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.events.EventsAgreement

class LeaderboardFragment :
    BaseFragmentImpl<LeaderboardAgreement.Presenter, LeaderboardAgreement.View>(R.layout.fragment_leaderboard),
    LeaderboardAgreement.View {
    override fun setupInputs() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun returnThisHerePlease(): LeaderboardAgreement.View = this
}