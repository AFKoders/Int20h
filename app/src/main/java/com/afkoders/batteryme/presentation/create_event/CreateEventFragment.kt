package com.afkoders.batteryme.presentation.create_event

import androidx.core.content.ContextCompat
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.utils.extensions.finish
import com.afkoders.batteryme.utils.extensions.formatMonth
import com.jakewharton.rxbinding2.widget.RxTextView
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import io.reactivex.Observable
import io.reactivex.functions.Function3
import kotlinx.android.synthetic.main.fragment_create_challenge.btnCreateChallenge
import kotlinx.android.synthetic.main.fragment_create_challenge.descriptionEditText
import kotlinx.android.synthetic.main.fragment_create_challenge.ivBack
import kotlinx.android.synthetic.main.fragment_create_challenge.titleEditText
import kotlinx.android.synthetic.main.fragment_create_event.*
import java.util.*

class CreateEventFragment :
    BaseFragmentImpl<CreateEventAgreement.Presenter, CreateEventAgreement.View>(R.layout.fragment_create_event),
    CreateEventAgreement.View {

    private var date: Calendar = Calendar.getInstance()

    override fun eventCreated() {
        finish()
    }

    override fun setupInputs() {
        ivBack.bindClick { finish() }

        Observable.combineLatest(
            RxTextView.textChanges(titleEditText),
            RxTextView.textChanges(descriptionEditText),
            RxTextView.textChanges(locationEditText),
            Function3 { t1: CharSequence, t2: CharSequence, t3: CharSequence -> Triple(t1, t2, t3) }
        )
            .subscribe { (title, description, location) ->
                btnCreateChallenge.isEnabled = title.isNotBlank() && description.isNotBlank() && location.isNotBlank()
            }.disposeByBagProvider()

        btnCreateChallenge.bindClick {
            presenter.createEvent(titleEditText.text.toString(), descriptionEditText.text.toString(), locationEditText.text.toString(), date.time)
        }

        btnDate.bindClick {
            DatePickerDialog.newInstance { view, year, monthOfYear, dayOfMonth ->
                date.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                date.set(Calendar.YEAR, year)
                date.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                btnDate.text = "$dayOfMonth ${date.time.formatMonth()}"
            }
                .apply {
                    version = DatePickerDialog.Version.VERSION_2

                    setOkColor(
                        ContextCompat.getColor(
                            this@CreateEventFragment.requireContext(),
                            R.color.ctaPrimaryTextColor
                        )
                    )
                    setCancelColor(
                        ContextCompat.getColor(
                            this@CreateEventFragment.requireContext(),
                            R.color.ctaPrimaryTextColor
                        )
                    )
                }
                .show(parentFragmentManager, "DatePickerDialog")
        }

        btnTime.bindClick {
            com.wdullaer.materialdatetimepicker.time.TimePickerDialog.newInstance({ view, hourOfDay, minute, second ->
                date.set(Calendar.HOUR_OF_DAY, hourOfDay)
                date.set(Calendar.MINUTE, minute)
                date.set(Calendar.SECOND, second)
                btnTime.text = "$hourOfDay:$minute"
            }, true)
                .apply {
                    version = com.wdullaer.materialdatetimepicker.time.TimePickerDialog.Version.VERSION_2

                    setOkColor(
                        ContextCompat.getColor(
                            this@CreateEventFragment.requireContext(),
                            R.color.ctaPrimaryTextColor
                        )
                    )
                    setCancelColor(
                        ContextCompat.getColor(
                            this@CreateEventFragment.requireContext(),
                            R.color.ctaPrimaryTextColor
                        )
                    )
                }
                .show(parentFragmentManager, "TimePickerDialog")
        }
    }

    override fun onResume() {
        super.onResume()
        btnDate.text = "${date.get(Calendar.DAY_OF_MONTH)} ${date.time.formatMonth()}"
        btnTime.text = "${date.get(Calendar.HOUR_OF_DAY)}:${date.get(Calendar.MINUTE)}"
    }

    override fun returnThisHerePlease(): CreateEventAgreement.View = this

    override fun showLoading() {
        // TODO
    }

    override fun hideLoading() {
        // TODO
    }

}