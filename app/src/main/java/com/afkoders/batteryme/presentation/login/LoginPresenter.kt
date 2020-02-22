package com.afkoders.batteryme.presentation.login

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.common.models.User
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val appPrefs: AppPrefs) :
    BasePresenterImpl<String, LoginAgreement.View>(),
    LoginAgreement.Presenter {


    override fun saveUserToPrefs(user: User): Boolean {
        appPrefs.putUser(user)
        return true
    }
}