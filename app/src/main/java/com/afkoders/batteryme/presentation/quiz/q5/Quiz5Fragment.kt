package com.afkoders.batteryme.presentation.quiz.q5

import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.utils.extensions.spanWith
import kotlinx.android.synthetic.main.fragment_quiz_1.ivBack
import kotlinx.android.synthetic.main.fragment_quiz_1.tvQuizTitle
import kotlinx.android.synthetic.main.fragment_quiz_2.ctaNegative
import kotlinx.android.synthetic.main.fragment_quiz_2.ctaPositive


class Quiz5Fragment :
    BaseFragmentImpl<Quiz5Agreement.Presenter, Quiz5Agreement.View>(R.layout.fragment_quiz_4),
    Quiz5Agreement.View {

    override fun setupInputs() {
        ivBack.bindClick {
            findNavController().navigate(R.id.action_quiz5Fragment_to_quiz4Fragment)
        }

        val spannableText = SpannableString("5/5 Do your eyes bother you while you work?")
            .spanWith("5/5") {
                whats = listOf(
                    ForegroundColorSpan(
                        ContextCompat.getColor(
                            this@Quiz5Fragment.requireContext(),
                            R.color.textSecondaryLight
                        )
                    )
                )
                flags = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            }
        tvQuizTitle.text = spannableText

        ctaNegative.bindClick {
            findNavController().navigate(R.id.action_quiz5Fragment_to_quiz4Fragment)
        }

        ctaPositive.bindClick {
            findNavController().navigate(R.id.action_quiz5Fragment_to_quizFinishFragment)
        }
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun returnThisHerePlease(): Quiz5Agreement.View = this

}

