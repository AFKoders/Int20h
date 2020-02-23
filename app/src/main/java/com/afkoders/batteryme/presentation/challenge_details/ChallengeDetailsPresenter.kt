package com.afkoders.batteryme.presentation.challenge_details

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.data.repository.Repository
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.challenges.model.Challenge
import javax.inject.Inject

class ChallengeDetailsPresenter @Inject constructor(private val appPrefs: AppPrefs,
                                                    private val repository: Repository) :
    BasePresenterImpl<Challenge, ChallengeDetailsAgreement.View>(),
    ChallengeDetailsAgreement.Presenter {
    override fun joinToChallenge() {
        repository.addUserToChallenge(appPrefs.user, model!!.id)
    }

    override fun leaveFromChallenge() {
        repository.removeUserFromChallenge(appPrefs.user, model!!.id)
    }

    override fun setModel(challenge: Challenge) {
        model = challenge
        view?.initButton(challenge.users.contains(appPrefs.user))
        view?.showData(challenge)
    }
}