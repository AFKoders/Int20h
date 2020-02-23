package com.afkoders.batteryme.presentation.splash

import androidx.navigation.fragment.findNavController
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl

class SplashFragment :
    BaseFragmentImpl<SplashAgreement.Presenter, SplashAgreement.View>(R.layout.fragment_splash),
    SplashAgreement.View {
    override fun setupInputs() {
            presenter.fire()
    }

    override fun redirect() {
        findNavController().navigate(R.id.action_to_login_fragment)
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun returnThisHerePlease(): SplashAgreement.View = this

}

