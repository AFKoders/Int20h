package com.afkoders.batteryme.presentation.login

import android.app.Activity.RESULT_CANCELED
import android.content.Intent
import android.view.View
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment :
    BaseFragmentImpl<LoginAgreement.Presenter, LoginAgreement.View>(R.layout.fragment_login),
    LoginAgreement.View {
    lateinit var mGoogleSignInClient: GoogleSignInClient
    override fun setupInputs() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)

        val account = GoogleSignIn.getLastSignedInAccount(requireActivity())
        updateUserPrefs(account?.email)

        if (account != null) {
            setupSignout()
        } else {
            setupSignin()
        }

        sign_in_button.bindClick {
            signIn()
        }

        sign_out_button.bindClick {
            mGoogleSignInClient.signOut()
            setupSignin()
            updateUserPrefs("")
        }
    }

    private fun signIn() {
        val signInIntent = mGoogleSignInClient.getSignInIntent()
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun handleSignInResult(result: GoogleSignInAccount?) {
        val account = result?.account
        updateUserPrefs(account?.name)
        setupSignout()
    }

    private fun setupSignout() {
        sign_in_button.visibility = View.GONE
        sign_out_button.visibility = View.VISIBLE
    }

    private fun setupSignin() {
        sign_in_button.visibility = View.VISIBLE
        sign_out_button.visibility = View.GONE
    }


    private fun updateUserPrefs(user: String?) {
        presenter.saveUserToPrefs()
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode != RESULT_CANCELED) {
            if (requestCode == RC_SIGN_IN) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                handleSignInResult(task.result)
            }
        }
    }

    override fun returnThisHerePlease(): LoginAgreement.View = this

    companion object {
        const val RC_SIGN_IN = 111
    }
}