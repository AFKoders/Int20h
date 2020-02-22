package com.afkoders.batteryme.presentation.login

import com.afkoders.batteryme.presentation.base.BasePresenter
import com.afkoders.batteryme.presentation.base.BaseView
import com.afkoders.batteryme.presentation.common.models.User

interface LoginAgreement {
    interface View: BaseView {

    }

    interface Presenter: BasePresenter<View> {
        fun saveUserToPrefs(user: User): Boolean
    }
}