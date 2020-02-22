package com.afkoders.batteryme.presentation.battery

import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl

class BatteryFragment :
    BaseFragmentImpl<BatteryAgreement.Presenter, BatteryAgreement.View>(R.layout.fragment_battery),
    BatteryAgreement.View {
    override fun setupInputs() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun returnThisHerePlease(): BatteryAgreement.View = this
}