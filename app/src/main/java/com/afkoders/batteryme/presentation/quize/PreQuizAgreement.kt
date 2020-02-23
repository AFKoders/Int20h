package com.afkoders.batteryme.presentation.quize

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView

interface PreQuizAgreement {
    interface View : BaseView

    interface Presenter : BasePresenter<View>
}