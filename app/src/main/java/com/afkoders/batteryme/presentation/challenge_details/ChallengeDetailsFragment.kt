package com.afkoders.batteryme.presentation.challenge_details

import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.challenges.model.Challenge
import com.afkoders.batteryme.utils.extensions.*
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_challenge_details.*

class ChallengeDetailsFragment :
    BaseFragmentImpl<ChallengeDetailsAgreement.Presenter, ChallengeDetailsAgreement.View>(R.layout.fragment_challenge_details),
    ChallengeDetailsAgreement.View {

    override fun setupInputs() {
        ivBack.bindClick { finish() }
    }

    override fun onResume() {
        super.onResume()
        presenter.setModel(arguments?.getSerializable(CHALLENGE_PARAMETER) as Challenge)
    }

    override fun showData(challenge: Challenge) {
        tvTitle.text = challenge.title
        tvDescription.text = challenge.description

        challenge.users.forEach {
            val flUser = FrameLayout(requireContext()).apply {
                layoutParams = LinearLayout.LayoutParams(
                    48.dpToPx(requireContext()),
                    48.dpToPx(requireContext())
                ).apply {
                    marginStart = (-16).dpToPx(requireContext())
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
            Glide.with(requireContext()).load(it.photo).into(ivUser)

            flUser.addView(ivUser)
            llUsers.addView(flUser)
        }
    }

    override fun joinedToChallenge() {
        btnJoinLeaveChallenge.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.redButton
            )
        )
        btnJoinLeaveChallenge.bindClick { presenter.leaveFromChallenge() }
    }

    override fun leavedFromChallenge() {
        btnJoinLeaveChallenge.setBackgroundColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.colorPrimary
            )
        )
        btnJoinLeaveChallenge.bindClick { presenter.joinToChallenge() }
    }

    override fun initButton(isJoined: Boolean) {
        if (isJoined) {
            joinedToChallenge()
        } else {
            leavedFromChallenge()
        }
    }

    override fun returnThisHerePlease(): ChallengeDetailsAgreement.View = this

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    companion object {
        const val CHALLENGE_PARAMETER = "ChallengeDetailsScreen.DATA.challenge"
    }

}