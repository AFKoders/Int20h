package com.afkoders.batteryme.presentation.quiz.q1

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView

interface Quiz1Agreement {
    interface View : BaseView

    interface Presenter : BasePresenter<View>
}