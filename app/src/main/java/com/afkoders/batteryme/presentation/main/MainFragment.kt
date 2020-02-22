package com.afkoders.batteryme.presentation.main

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.test.TestAgreement
import com.afkoders.batteryme.utils.extensions.widget.makeGone
import com.afkoders.batteryme.utils.extensions.widget.makeVisible
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment :
    BaseFragmentImpl<MainFragmentAgreement.Presenter, MainFragmentAgreement.View>(R.layout.fragment_main),
    MainFragmentAgreement.View {

    private lateinit var currentFragment: Fragment

    override fun setupInputs() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            sectionBattery.makeGone()
            sectionChallenges.makeGone()
            sectionEvents.makeGone()
            sectionLeaderboard.makeGone()

            when (it.itemId) {
                R.id.menuItemBattery -> sectionBattery
                R.id.menuItemChallenges -> sectionChallenges
                R.id.menuItemEvents -> sectionEvents
                R.id.menuItemLeaderboard -> sectionLeaderboard
                else -> sectionBattery
            }.makeVisible()

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
