package com.afkoders.hackathon.presentation.test

import com.afkoders.hackathon.presentation.base.BasePresenter
import com.afkoders.hackathon.presentation.base.BaseView

interface TestAgreement {
    interface View: BaseView {
        fun populateData(data: List<String>)
        fun showError()
    }

    interface Presenter: BasePresenter<View> {
        fun loadData()
    }
}