package com.afkoders.batteryme.presentation.challenges

import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl

class ChallengesFragment :
    BaseFragmentImpl<ChallengesAgreement.Presenter, ChallengesAgreement.View>(R.layout.fragment_challenges),
    ChallengesAgreement.View {
    override fun setupInputs() {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun returnThisHerePlease(): ChallengesAgreement.View = this
}