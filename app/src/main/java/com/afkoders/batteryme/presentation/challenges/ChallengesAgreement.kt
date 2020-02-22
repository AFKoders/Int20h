package com.afkoders.batteryme.presentation.challenges

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem

interface ChallengesAgreement {
    interface View: BaseView {
        fun populateData(data: List<AdapterDelegateItem>)
    }

    interface Presenter: BasePresenter<View> {
        fun uploadData()
    }
}