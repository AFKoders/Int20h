package com.afkoders.batteryme.presentation.logout

import androidx.navigation.fragment.findNavController
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.android.synthetic.main.fragment_logout.*

class LogoutFragment :
    BaseFragmentImpl<LogoutAgreement.Presenter, LogoutAgreement.View>(R.layout.fragment_logout),
    LogoutAgreement.View {

    lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun setupInputs() {
            buttonLogout.bindClick{
                presenter.fire()
            }

        imageView2.bindClick {
            findNavController().popBackStack()
        }
    }

    override fun redirect() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
        mGoogleSignInClient.signOut()
        findNavController().navigate(R.id.action_logout_to_login_fragment)
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun returnThisHerePlease(): LogoutAgreement.View = this

}

