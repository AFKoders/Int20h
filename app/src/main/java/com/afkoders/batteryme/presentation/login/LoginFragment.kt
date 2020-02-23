package com.afkoders.batteryme.presentation.login

import android.app.Activity.RESULT_CANCELED
import android.content.Intent
import androidx.navigation.fragment.findNavController
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.common.models.User
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

        if (account != null) {
            navigateToMainScreen()
        }

        sign_in_button.bindClick {
            signIn()
        }

        tvSignin.bindClick { signIn() }
    }

    private fun navigateToMainScreen() {
        findNavController().navigate(R.id.action_to_main_fragment)
    }

    private fun navigateToQuiz(){
        findNavController().navigate(R.id.action_to_quiz)
    }

    private fun signIn() {
        val signInIntent = mGoogleSignInClient.getSignInIntent()
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun handleSignInResult(result: GoogleSignInAccount?) {
        updateUserPrefs(result)

        if(presenter.isUserPassedQuiz()) {
            navigateToMainScreen()
        } else {
            navigateToQuiz()
        }
    }


    private fun updateUserPrefs(account: GoogleSignInAccount?) {
        var user = User(
            account?.account?.name ?: "",
            account?.givenName ?: "",
            account?.familyName ?: "",
            account?.email ?: "",
            account?.id ?: "",
            account?.photoUrl?.normalizeScheme().toString(),
            99
        )
        presenter.saveUserToPrefs(user)
    }

    override fun showLoading() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_CANCELED) {
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

