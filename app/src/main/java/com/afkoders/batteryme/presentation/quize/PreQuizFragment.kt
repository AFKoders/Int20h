package com.afkoders.batteryme.presentation.quize

import android.widget.Toast
import androidx.core.content.ContextCompat
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog


class PreQuizFragment :
    BaseFragmentImpl<PreQuizAgreement.Presenter, PreQuizAgreement.View>(R.layout.fragment_pre_quiz),
    PreQuizAgreement.View, TimePickerDialog.OnTimeSetListener {

    override fun onTimeSet(view: TimePickerDialog?, hourOfDay: Int, minute: Int, second: Int) {
        val time = "You picked the following time: " + hourOfDay + "h" + minute + "m" + second
        Toast.makeText(requireContext(), time, Toast.LENGTH_SHORT).show()
    }

    override fun setupInputs() {
        TimePickerDialog.newInstance(this, false)
            .apply {
                version = TimePickerDialog.Version.VERSION_2

                setOkColor(
                    ContextCompat.getColor(
                        this@PreQuizFragment.requireContext(),
                        R.color.ctaPrimaryTextColor
                    )
                )
                setCancelColor(
                    ContextCompat.getColor(
                        this@PreQuizFragment.requireContext(),
                        R.color.ctaPrimaryTextColor
                    )
                )
            }
            .show(parentFragmentManager, "TimePickerDialog")
    }

    private fun navigateToQuizeScreen() {
//        findNavController().navigate(R.id.action_to_main_fragment)
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun returnThisHerePlease(): PreQuizAgreement.View = this

}

