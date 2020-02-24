package com.afkoders.batteryme.presentation.event_details

import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.events.model.Event
import com.afkoders.batteryme.utils.extensions.*
import com.afkoders.batteryme.utils.extensions.widget.makeVisible
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_event_details.*
import kotlinx.android.synthetic.main.fragment_event_details.ivBack
import kotlinx.android.synthetic.main.fragment_event_details.llUsers
import kotlinx.android.synthetic.main.fragment_event_details.tvDescription
import kotlinx.android.synthetic.main.fragment_event_details.tvTitle

class EventDetailsFragment :
    BaseFragmentImpl<EventDetailsAgreement.Presenter, EventDetailsAgreement.View>(R.layout.fragment_event_details),
    EventDetailsAgreement.View {
    override fun setupInputs() {
        ivBack.bindClick { finish() }
    }

    override fun onResume() {
        super.onResume()
        presenter.setModel(arguments?.getSerializable(EVENT_PARAMETER) as Event)
    }

    override fun joinedToEvent() {
        btnJoinLeaveEvent.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.redButton
            )
        )
        btnJoinLeaveEvent.text = "Leave the event"
        btnJoinLeaveEvent.bindClick { presenter.leaveFromEvent() }
    }

    override fun leavedFromEvent() {
        btnJoinLeaveEvent.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.colorPrimary
            )
        )
        btnJoinLeaveEvent.text = "Join the event"
        btnJoinLeaveEvent.bindClick { presenter.joinToEvent() }
    }

    override fun initButton(isJoined: Boolean) {
        btnJoinLeaveEvent.makeVisible()
        if (isJoined) {
            joinedToEvent()
        } else {
            leavedFromEvent()
        }
    }

    override fun finishScreen() {
        finish()
    }

    override fun returnThisHerePlease(): EventDetailsAgreement.View = this

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun showData(event: Event) {
        tvTitle.text = event.title
        tvDescription.text = event.description
        tvLocation.text = event.location
        tvExactDate.text = event.dateTime.formatEventDate()
        tvExactTime.text = event.dateTime.formatEventTime()
        tvDate.text = event.dateTime.formatShortDate()

        event.users.forEach {
            val flUser = FrameLayout(requireContext()).apply {
                layoutParams = LinearLayout.LayoutParams(
                    48.dp(requireContext()),
                    48.dp(requireContext())
                ).apply {
                    marginStart = (-16).dp(requireContext())
                }
                background =
                    AppCompatResources.getDrawable(requireContext(), R.drawable.background_user)
            }
            val ivUser = ImageView(requireContext()).apply {
                layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
            }
            Glide.with(requireContext()).load(it.photo).placeholder(R.drawable.ic_placeholder_users)
                .into(ivUser)

            flUser.addView(ivUser)
            llUsers.addView(flUser)
        }
    }

    companion object {
        const val EVENT_PARAMETER = "CreateEventScreen.DATA.event"
    }

}
