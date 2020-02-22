package com.afkoders.batteryme.presentation.battery

import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl

class BatteryFragment :
    BaseFragmentImpl<BatteryAgreement.Presenter, BatteryAgreement.View>(R.layout.fragment_battery),
    BatteryAgreement.View {
    override fun setupInputs() {

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun returnThisHerePlease(): BatteryAgreement.View = this
}