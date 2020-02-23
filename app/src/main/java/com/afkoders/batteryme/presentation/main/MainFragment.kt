package com.afkoders.batteryme.presentation.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.challenge_details.ChallengeDetailsAgreement
import com.afkoders.batteryme.presentation.challenge_details.ChallengeDetailsFragment
import com.afkoders.batteryme.presentation.challenges.model.Challenge
import com.afkoders.batteryme.presentation.event_details.EventDetailsFragment
import com.afkoders.batteryme.presentation.events.model.Event
import com.afkoders.batteryme.utils.extensions.collapse
import com.afkoders.batteryme.utils.extensions.dpToPx
import com.afkoders.batteryme.utils.extensions.hide
import com.afkoders.batteryme.utils.extensions.navigateTo
import com.afkoders.batteryme.utils.extensions.widget.makeGone
import com.afkoders.batteryme.utils.extensions.widget.makeVisible
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.bottom_sheet_notifications.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment :
    BaseFragmentImpl<MainFragmentAgreement.Presenter, MainFragmentAgreement.View>(R.layout.fragment_main),
    MainFragmentAgreement.View {

    private lateinit var bottomSheetNotifications: BottomSheetBehavior<View>
    private var currentFragmentId: Int = R.id.menuItemBattery

    private val cornerRadius by lazy { 16.dpToPx(requireContext()) }
    private val elevation by lazy { 8.dpToPx(requireContext()) }

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

            currentFragmentId = it.itemId
            when (it.itemId) {
                R.id.menuItemBattery -> {
                    sectionBattery.makeVisible()
                    it.icon = AppCompatResources.getDrawable(
                        requireContext(),
                        R.drawable.ic_battery_selected
                    )
                }
                R.id.menuItemChallenges -> {
                    sectionChallenges.makeVisible()
                    it.icon = AppCompatResources.getDrawable(
                        requireContext(),
                        R.drawable.ic_challenges_selected
                    )
                }
                R.id.menuItemEvents -> {
                    sectionEvents.makeVisible()
                    it.icon = AppCompatResources.getDrawable(
                        requireContext(),
                        R.drawable.ic_events_selected
                    )
                }
                R.id.menuItemLeaderboard -> {
                    sectionLeaderboard.makeVisible()
                    it.icon = AppCompatResources.getDrawable(
                        requireContext(),
                        R.drawable.ic_leaderboard_selected
                    )
                }
                else -> {
                    sectionBattery.makeVisible()
                    it.icon = AppCompatResources.getDrawable(
                        requireContext(),
                        R.drawable.ic_battery_selected
                    )
                }
            }

            true
        }

        bottomSheetNotifications = BottomSheetBehavior.from(bsNotifications)
        bottomSheetNotifications.addBottomSheetCallback(getBottomSheetCallback())
        bottomSheetNotifications.collapse()
        setTextsForNotifications(
            title = "It’s time to shake your body!",
            message = "Don’t hesitate to take some time off if it means you’ll be a better worker."
        )

        ivClose.bindClick {
            bottomSheetNotifications.hide()
            // TODO: handle dismiss
        }

        ctaNegative.bindClick {
            bottomSheetNotifications.hide()
            // TODO: handle dismiss
        }

        ctaPositive.bindClick {
            bottomSheetNotifications.hide()
            // TODO: handle submit
        }
    }

    private fun getBottomSheetCallback(): BottomSheetBehavior.BottomSheetCallback {
        return object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                changeUiOnSlide(slideOffset)
            }

            @SuppressLint("SwitchIntDef")
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        // TODO: handle dismiss
                    }
                }
            }
        }
    }

    private fun changeUiOnSlide(slideOffset: Float = 0f) {
        ivLine.alpha = (1 - slideOffset)
        ivClose.alpha = slideOffset
        cvRootBottomSheet.radius = (1 - slideOffset) * cornerRadius
        cvRootBottomSheet.cardElevation = (1 - slideOffset) * elevation
    }

    override fun showLoading() {
        // Empty
    }

    override fun hideLoading() {
        // Empty
    }

    override fun onResume() {
        super.onResume()
        bottomNavigationView.selectedItemId = currentFragmentId
    }

    override fun returnThisHerePlease(): MainFragmentAgreement.View = this

    private fun setTextsForNotifications(title: String, message: String) {
        tvNotificationTitle.text = title
        tvNotificationMessage.text = message
        ivLine.alpha = 0.8f
        ivClose.alpha = 0f
    }

    fun navigateToEventDetailsFragment(event: Event) {
        findNavController().navigateTo(R.id.action_mainFragment_to_eventDetailsFragment) {
            putSerializable(EventDetailsFragment.EVENT_PARAMETER, event)
        }
    }

    fun navigateToChallengeDetails(challenge: Challenge) {
        findNavController().navigateTo(R.id.action_mainFragment_to_challengeDetailsFragment) {
            putSerializable(ChallengeDetailsFragment.CHALLENGE_PARAMETER, challenge)
        }
    }
}
