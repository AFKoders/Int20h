package com.afkoders.batteryme.presentation.quiz.q2

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
import kotlinx.android.synthetic.main.fragment_quiz_2.*


class Quiz2Fragment :
    BaseFragmentImpl<Quiz2Agreement.Presenter, Quiz2Agreement.View>(R.layout.fragment_quiz_2),
    Quiz2Agreement.View {

    override fun setupInputs() {
        ivBack.bindClick {
            findNavController().navigate(R.id.action_quiz2Fragment_to_quiz1Fragment)
        }

        val spannableText = SpannableString("2/5 How many times per day do you drink a water?")
            .spanWith("2/5") {
                whats = listOf(
                    ForegroundColorSpan(
                        ContextCompat.getColor(
                            this@Quiz2Fragment.requireContext(),
                            R.color.textSecondaryLight
                        )
                    )
                )
                flags = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            }
        tvQuizTitle.text = spannableText

        holderTimesDayInput

        ctaNegative.bindClick {
            findNavController().navigate(R.id.action_quiz2Fragment_to_quiz1Fragment)
        }

        ctaPositive.bindClick {
            findNavController().navigate(R.id.action_quiz2Fragment_to_quiz3Fragment)
        }
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun returnThisHerePlease(): Quiz2Agreement.View = this

}

