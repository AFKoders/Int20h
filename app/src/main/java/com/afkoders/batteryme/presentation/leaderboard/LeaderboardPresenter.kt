package com.afkoders.batteryme.presentation.leaderboard

import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import javax.inject.Inject

class LeaderboardPresenter @Inject constructor():
    BasePresenterImpl<Unit /* TODO change model here */, LeaderboardAgreement.View>(),
    LeaderboardAgreement.Presenter {

}