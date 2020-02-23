package com.afkoders.batteryme.presentation.quiz.q3

import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.utils.extensions.spanWith
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import kotlinx.android.synthetic.main.fragment_quiz_1.ivBack
import kotlinx.android.synthetic.main.fragment_quiz_1.tvQuizTitle
import kotlinx.android.synthetic.main.fragment_quiz_2.*
import kotlinx.android.synthetic.main.fragment_quiz_2.ctaNegative
import kotlinx.android.synthetic.main.fragment_quiz_2.ctaPositive
import kotlinx.android.synthetic.main.fragment_quiz_3.*


class Quiz3Fragment :
    BaseFragmentImpl<Quiz3Agreement.Presenter, Quiz3Agreement.View>(R.layout.fragment_quiz_3),
    Quiz3Agreement.View {

    override fun setupInputs() {
        ivBack.bindClick {
            findNavController().navigate(R.id.action_quiz3Fragment_to_quiz2Fragment)
        }

        val spannableText = SpannableString("3/5 When do you usually have lunch?")
            .spanWith("3/5") {
                whats = listOf(
                    ForegroundColorSpan(
                        ContextCompat.getColor(
                            this@Quiz3Fragment.requireContext(),
                            R.color.textSecondaryLight
                        )
                    )
                )
                flags = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            }
        tvQuizTitle.text = spannableText

        holderFrom.bindClick {
            TimePickerDialog.newInstance({ view, hourOfDay, minute, _ ->
                holderFrom.text = "$hourOfDay:$minute"
            }, true)
                .apply {
                    version = TimePickerDialog.Version.VERSION_2

                    setOkColor(
                        ContextCompat.getColor(
                            this@Quiz3Fragment.requireContext(),
                            R.color.ctaPrimaryTextColor
                        )
                    )
                    setCancelColor(
                        ContextCompat.getColor(
                            this@Quiz3Fragment.requireContext(),
                            R.color.ctaPrimaryTextColor
                        )
                    )
                }
                .show(parentFragmentManager, "TimePickerDialog")
        }

        ctaNegative.bindClick {
            findNavController().navigate(R.id.action_quiz3Fragment_to_quiz2Fragment)
        }

        ctaPositive.bindClick {
            //            findNavController().navigate(R.id.action_quiz2Fragment_to_quiz1Fragment)
        }
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun returnThisHerePlease(): Quiz3Agreement.View = this

}

