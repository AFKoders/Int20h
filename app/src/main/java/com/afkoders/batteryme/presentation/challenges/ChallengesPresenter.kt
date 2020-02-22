package com.afkoders.batteryme.presentation.challenges

import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import javax.inject.Inject

class ChallengesPresenter @Inject constructor():
    BasePresenterImpl<Unit /* TODO change model here */, ChallengesAgreement.View>(),
    ChallengesAgreement.Presenter {

}