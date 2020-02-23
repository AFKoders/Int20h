package com.afkoders.batteryme.presentation.quiz.q4

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


class Quiz4Fragment :
    BaseFragmentImpl<Quiz4Agreement.Presenter, Quiz4Agreement.View>(R.layout.fragment_quiz_4),
    Quiz4Agreement.View {

    override fun setupInputs() {
        ivBack.bindClick {
            findNavController().navigate(R.id.action_quiz4Fragment_to_quiz3Fragment)
        }

        val spannableText = SpannableString("4/5 Does your back or neck hurt?")
            .spanWith("4/5") {
                whats = listOf(
                    ForegroundColorSpan(
                        ContextCompat.getColor(
                            this@Quiz4Fragment.requireContext(),
                            R.color.textSecondaryLight
                        )
                    )
                )
                flags = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            }
        tvQuizTitle.text = spannableText

        ctaNegative.bindClick {
            findNavController().navigate(R.id.action_quiz4Fragment_to_quiz3Fragment)
        }

        ctaPositive.bindClick {
            findNavController().navigate(R.id.action_quiz4Fragment_to_quiz5Fragment)
        }
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun returnThisHerePlease(): Quiz4Agreement.View = this

}

