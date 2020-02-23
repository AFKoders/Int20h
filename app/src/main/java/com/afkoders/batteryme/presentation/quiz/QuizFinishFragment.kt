package com.afkoders.batteryme.presentation.quiz

import androidx.navigation.fragment.findNavController
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl


class QuizFinishFragment :
    BaseFragmentImpl<QuizFinishAgreement.Presenter, QuizFinishAgreement.View>(R.layout.fragment_quiz_finish),
    QuizFinishAgreement.View {

    override fun setupInputs() {
        presenter.fire()
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun redirect() {
        findNavController().navigate(R.id.action_quizFinishFragment_to_mainFragment)
    }

    override fun returnThisHerePlease(): QuizFinishAgreement.View = this

}

