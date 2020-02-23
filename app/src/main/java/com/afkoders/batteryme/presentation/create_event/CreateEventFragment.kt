package com.afkoders.batteryme.presentation.create_event

import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.utils.extensions.finish
import com.jakewharton.rxbinding2.widget.RxTextView
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
            presenter.createEvent(titleEditText.text.toString(), descriptionEditText.text.toString(), locationEditText.text.toString(), Date())
        }
    }

    override fun returnThisHerePlease(): CreateEventAgreement.View = this

    override fun showLoading() {
        // TODO
    }

    override fun hideLoading() {
        // TODO
    }

}