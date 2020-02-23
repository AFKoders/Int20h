package com.afkoders.batteryme.presentation.quiz

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView

interface QuizFinishAgreement {
    interface View : BaseView {
        fun redirect()
    }

    interface Presenter : BasePresenter<View> {
        fun fire()
    }
}