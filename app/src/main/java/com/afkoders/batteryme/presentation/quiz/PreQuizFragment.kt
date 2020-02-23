package com.afkoders.batteryme.presentation.quiz

import androidx.navigation.fragment.findNavController
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import kotlinx.android.synthetic.main.fragment_pre_quiz.*


class PreQuizFragment :
    BaseFragmentImpl<PreQuizAgreement.Presenter, PreQuizAgreement.View>(R.layout.fragment_pre_quiz),
    PreQuizAgreement.View {

    override fun setupInputs() {
        ctaPositive.bindClick {
            findNavController().navigate(R.id.action_quizeFragment_to_quiz1Fragment)
        }
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun returnThisHerePlease(): PreQuizAgreement.View = this

}

