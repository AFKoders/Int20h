package com.afkoders.batteryme.presentation.battery

import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.dialogs.ConfirmationDialog

class BatteryFragment :
    BaseFragmentImpl<BatteryAgreement.Presenter, BatteryAgreement.View>(R.layout.fragment_battery),
    BatteryAgreement.View {

    override fun setupInputs() {

        ConfirmationDialog.createDialog {
            title = "It’s time to shake your body!"
            message = "Workers have the right to one uninterrupted " +
                    "20 minute rest break during their working day"
            actionPositiveText = "Deal with it"
            actionNegativeText = "Dismiss"
        }
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun returnThisHerePlease(): BatteryAgreement.View = this
}