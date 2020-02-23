package com.afkoders.batteryme.presentation.challenge_details

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView
import com.afkoders.batteryme.presentation.challenges.model.Challenge

interface ChallengeDetailsAgreement {
    interface View : BaseView {
        fun showData(challenge: Challenge)
        fun joinedToChallenge()
        fun leavedFromChallenge()
        fun initButton(isJoined: Boolean)
    }

    interface Presenter : BasePresenter<View> {
        fun joinToChallenge()
        fun leaveFromChallenge()
        fun setModel(challenge: Challenge)
    }
}