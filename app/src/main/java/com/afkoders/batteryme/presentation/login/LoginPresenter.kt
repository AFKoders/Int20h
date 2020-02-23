package com.afkoders.batteryme.presentation.login

import android.util.Log
import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.data.repository.Repository
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.challenges.model.Challenge
import com.afkoders.batteryme.presentation.common.models.User
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val appPrefs: AppPrefs,
    private val repository: Repository
) :
    BasePresenterImpl<String, LoginAgreement.View>(),
    LoginAgreement.Presenter {


    override fun saveUserToPrefs(user: User): Boolean {
        appPrefs.putUser(user)
        repository.addUserRemote(user)

        return true
    }

    override fun isUserPassedQuiz(): Boolean {
        return appPrefs.isUserPassedQuiz()
    }
}