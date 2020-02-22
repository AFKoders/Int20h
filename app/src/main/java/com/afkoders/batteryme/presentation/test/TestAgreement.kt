package com.afkoders.batteryme.presentation.test

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView

interface TestAgreement {
    interface View: BaseView {
        fun populateData(data: List<String>)
        fun showError()
    }

    interface Presenter: BasePresenter<View> {
        fun loadData()
    }
}