package com.afkoders.batteryme.presentation.battery

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.dialogs.ConfirmationDialog
import com.afkoders.batteryme.presentation.main.MainFragment
import com.afkoders.batteryme.utils.extensions.dpToPx
import com.afkoders.batteryme.utils.extensions.navigateTo
import kotlinx.android.synthetic.main.fragment_battery.*

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

        ivSettings.bindClick {
            (parentFragment as MainFragment).navigateToSettings()


        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vBattery.innerCoeficient = 8.dpToPx(requireContext()).toFloat()

    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun returnThisHerePlease(): BatteryAgreement.View = this
}