package com.afkoders.batteryme.presentation.login

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val appPrefs: AppPrefs):
    BasePresenterImpl<String, LoginAgreement.View>(),
    LoginAgreement.Presenter {


    override fun saveUserToPrefs(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}