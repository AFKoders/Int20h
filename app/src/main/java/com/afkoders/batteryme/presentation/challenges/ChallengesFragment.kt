package com.afkoders.batteryme.presentation.challenges

import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl

class ChallengesFragment :
    BaseFragmentImpl<ChallengesAgreement.Presenter, ChallengesAgreement.View>(R.layout.fragment_challenges),
    ChallengesAgreement.View {
    override fun setupInputs() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun returnThisHerePlease(): ChallengesAgreement.View = this
}