package com.afkoders.batteryme.presentation.battery

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.dialogs.ConfirmationDialog
import com.afkoders.batteryme.presentation.main.MainFragment
import com.afkoders.batteryme.utils.extensions.dpToPx
import kotlinx.android.synthetic.main.fragment_battery.*
import kotlinx.android.synthetic.main.item_leaderboard.*


class BatteryFragment :
    BaseFragmentImpl<BatteryAgreement.Presenter, BatteryAgreement.View>(com.afkoders.batteryme.R.layout.fragment_battery),
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

    override fun setPercentage(percents: Int) {
        vBattery.update(percents)
    }

    override fun onResume() {
        super.onResume()
        presenter.askPercentage()
        val va = ValueAnimator.ofInt(0, presenter.getPercentage())
        val mDuration = 2000L
        va.interpolator = AccelerateDecelerateInterpolator()
        va.duration = mDuration
        va.addUpdateListener { animation ->
            vBattery.update(animation.animatedValue as Int)
        }
        va.start()
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