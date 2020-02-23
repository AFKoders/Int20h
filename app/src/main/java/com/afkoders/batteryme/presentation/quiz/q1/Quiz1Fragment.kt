package com.afkoders.batteryme.presentation.quiz.q1

import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.utils.extensions.spanWith
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import kotlinx.android.synthetic.main.fragment_quiz_1.*


class Quiz1Fragment :
    BaseFragmentImpl<Quiz1Agreement.Presenter, Quiz1Agreement.View>(R.layout.fragment_quiz_1),
    Quiz1Agreement.View {

    override fun setupInputs() {
        ivBack.bindClick {
            findNavController().navigate(R.id.action_quiz1Fragment_to_quizeFragment)
        }

        val spannableText = SpannableString("1/5 What is your working time?")
            .spanWith("1/5") {
                whats = listOf(
                    ForegroundColorSpan(
                        ContextCompat.getColor(
                            this@Quiz1Fragment.requireContext(),
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
                            this@Quiz1Fragment.requireContext(),
                            R.color.ctaPrimaryTextColor
                        )
                    )
                    setCancelColor(
                        ContextCompat.getColor(
                            this@Quiz1Fragment.requireContext(),
                            R.color.ctaPrimaryTextColor
                        )
                    )
                }
                .show(parentFragmentManager, "TimePickerDialog")
        }

        holderTo.bindClick {
            TimePickerDialog.newInstance({ view, hourOfDay, minute, _ ->
                holderTo.text = "$hourOfDay:$minute"
            }, true)
                .apply {
                    version = TimePickerDialog.Version.VERSION_2

                    setOkColor(
                        ContextCompat.getColor(
                            this@Quiz1Fragment.requireContext(),
                            R.color.ctaPrimaryTextColor
                        )
                    )
                    setCancelColor(
                        ContextCompat.getColor(
                            this@Quiz1Fragment.requireContext(),
                            R.color.ctaPrimaryTextColor
                        )
                    )
                }
                .show(parentFragmentManager, "TimePickerDialog")
        }

        ctaPositive.bindClick {
            findNavController().navigate(R.id.action_quiz1Fragment_to_quiz2Fragment)
        }
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun returnThisHerePlease(): Quiz1Agreement.View = this

}

