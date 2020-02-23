package com.afkoders.batteryme.presentation.create_challenge

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.data.repository.Repository
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.challenges.model.Challenge
import com.afkoders.batteryme.presentation.events.model.Event
import javax.inject.Inject

class CreateChallengePresenter @Inject constructor(private val appPrefs: AppPrefs,
                                                   private val repository: Repository) :
    BasePresenterImpl<Challenge, CreateChallengeAgreement.View>(),
    CreateChallengeAgreement.Presenter {

    override fun createChallenge(title: String, description: String) {
        repository.addChallengeRemote(Challenge(title, description, mutableListOf()))
        view?.challengeCreated()
    }
}