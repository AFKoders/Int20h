package com.afkoders.batteryme.presentation.battery

import android.animation.ValueAnimator
import android.view.animation.AccelerateDecelerateInterpolator
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.main.MainFragment
import kotlinx.android.synthetic.main.fragment_battery.*


class BatteryFragment :
    BaseFragmentImpl<BatteryAgreement.Presenter, BatteryAgreement.View>(com.afkoders.batteryme.R.layout.fragment_battery),
    BatteryAgreement.View {

    override fun setupInputs() {
        ivSettings.bindClick {
            (parentFragment as MainFragment).navigateToSettings()
        }
    }

    override fun setPercentage(percents: Int) {
        vBattery.setProgress(percents)
    }

    override fun onResume() {
        super.onResume()
        presenter.askPercentage()
        presenter.startTimer()
        val va = ValueAnimator.ofInt(0, presenter.getPercentage())
        val mDuration = 2000L
        va.interpolator = AccelerateDecelerateInterpolator()
        va.duration = mDuration
        va.addUpdateListener { animation ->
            if (vBattery != null) {
                vBattery.setProgress(animation.animatedValue as Int)
            }
        }
        va.start()
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun returnThisHerePlease(): BatteryAgreement.View = this
}