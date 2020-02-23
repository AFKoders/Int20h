package com.afkoders.batteryme.presentation.main

import android.annotation.SuppressLint
import android.view.View
import androidx.navigation.fragment.findNavController
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
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

            bottomNavigationView.itemIconTintList = null

            currentFragmentId = it.itemId
            when (it.itemId) {
                R.id.menuItemBattery -> sectionBattery.makeVisible()
                R.id.menuItemChallenges -> sectionChallenges.makeVisible()
                R.id.menuItemEvents -> sectionEvents.makeVisible()
                R.id.menuItemLeaderboard -> sectionLeaderboard.makeVisible()
                else -> sectionBattery.makeVisible()
            }

            true
        }

        bottomSheetNotifications = BottomSheetBehavior.from(bsNotifications)
        bottomSheetNotifications.addBottomSheetCallback(getBottomSheetCallback())
        bottomSheetNotifications.hide()
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

        if(arguments?.getBoolean(PUSH_NOTIFICATION_EXTRA, false) == true) {
            arguments = null
            bottomSheetNotifications.collapse()
        }
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

    fun navigateToChallengeCreation() {
        findNavController().navigateTo(R.id.action_mainFragment_to_createChallengeFragment)
    }

    fun navigateToSettings() {
        findNavController().navigateTo(R.id.action_batteryFragment_to_settingsFragment)
    }

    fun navigateToEventCreation() {
        findNavController().navigateTo(R.id.action_mainFragment_to_createEventFragment)
    }

    companion object {
        const val PUSH_NOTIFICATION_EXTRA = "pushNotification.EXTRA"
    }
}
