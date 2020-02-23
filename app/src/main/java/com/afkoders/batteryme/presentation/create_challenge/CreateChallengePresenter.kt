package com.afkoders.batteryme.presentation.create_challenge

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.challenges.model.Challenge
import javax.inject.Inject

class CreateChallengePresenter @Inject constructor(private val appPrefs: AppPrefs) :
    BasePresenterImpl<Challenge, CreateChallengeAgreement.View>(),
    CreateChallengeAgreement.Presenter {

    override fun createChallenge(title: String, description: String) {
        // TODO zayzat Sashkina xernya
        view?.challengeCreated()
    }
}