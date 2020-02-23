package com.afkoders.batteryme.presentation.create_challenge

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView

interface CreateChallengeAgreement {
    interface View: BaseView {
        fun challengeCreated()
    }

    interface Presenter: BasePresenter<View> {
        fun createChallenge(title: String, description: String)
    }
}