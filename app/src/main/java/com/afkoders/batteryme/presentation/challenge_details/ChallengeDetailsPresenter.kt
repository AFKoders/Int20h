package com.afkoders.batteryme.presentation.challenge_details

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.challenges.model.Challenge
import javax.inject.Inject

class ChallengeDetailsPresenter @Inject constructor(private val appPrefs: AppPrefs) :
    BasePresenterImpl<Challenge, ChallengeDetailsAgreement.View>(),
    ChallengeDetailsAgreement.Presenter {
    override fun joinToChallenge() {
        // TODO
    }

    override fun leaveFromChallenge() {
        // TODO
    }

    override fun setModel(challenge: Challenge) {
        model = challenge
        view?.initButton(challenge.users.contains(appPrefs.user))
        view?.showData(challenge)
    }
}