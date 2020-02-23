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
        val challenge = Challenge(
            "Fire bucket challenge",
            "nice description",
            mutableListOf(
                user,
                User("another name", "givenName", "familyName", "email", "217727821", null, 66)
            )
        )
        repository.addChallengeRemote(
            challenge
        )

        repository.addUserToChallenge(User("fire lover", "oh yes", "oh ya", "hehe", "66661266216", null, 99), challenge.id)


        repository.getAllChallenges { challenges ->
            for(cha in challenges){
                Log.d("chacha", cha.users.toString())
            }
        }
        return true
    }
}