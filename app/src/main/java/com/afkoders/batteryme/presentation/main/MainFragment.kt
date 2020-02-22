package com.afkoders.batteryme.presentation.main

import androidx.appcompat.content.res.AppCompatResources
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.utils.extensions.widget.makeGone
import com.afkoders.batteryme.utils.extensions.widget.makeVisible
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment :
    BaseFragmentImpl<MainFragmentAgreement.Presenter, MainFragmentAgreement.View>(R.layout.fragment_main),
    MainFragmentAgreement.View {

    override fun setupInputs() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            sectionBattery.makeGone()
            sectionChallenges.makeGone()
            sectionEvents.makeGone()
            sectionLeaderboard.makeGone()

            val menu = bottomNavigationView.menu
            menu.findItem(R.id.menuItemBattery).icon =
                AppCompatResources.getDrawable(requireContext(), R.drawable.ic_battery)
            menu.findItem(R.id.menuItemEvents).icon =
                AppCompatResources.getDrawable(requireContext(), R.drawable.ic_events)
            menu.findItem(R.id.menuItemChallenges).icon =
                AppCompatResources.getDrawable(requireContext(), R.drawable.ic_challenges)
            menu.findItem(R.id.menuItemLeaderboard).icon =
                AppCompatResources.getDrawable(requireContext(), R.drawable.ic_leaderboard)

            when (it.itemId) {
                R.id.menuItemBattery -> {
                    sectionBattery.makeVisible()
                    it.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_battery_selected)
                }
                R.id.menuItemChallenges -> {
                    sectionChallenges.makeVisible()
                    it.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_challenges_selected)
                }
                R.id.menuItemEvents -> {
                    sectionEvents.makeVisible()
                    it.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_events_selected)
                }
                R.id.menuItemLeaderboard -> {
                    sectionLeaderboard.makeVisible()
                    it.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_leaderboard_selected)
                }
                else -> {
                    sectionBattery.makeVisible()
                    it.icon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_battery_selected)
                }
            }

            true
        }
    }

    override fun showLoading() {
        // Empty
    }

    override fun hideLoading() {
        // Empty
    }

    override fun returnThisHerePlease(): MainFragmentAgreement.View = this
}
