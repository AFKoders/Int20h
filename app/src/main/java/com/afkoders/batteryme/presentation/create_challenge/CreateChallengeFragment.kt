package com.afkoders.batteryme.presentation.create_challenge

import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.challenges.model.Challenge
import com.afkoders.batteryme.utils.extensions.finish
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.fragment_create_challenge.*

class CreateChallengeFragment :
    BaseFragmentImpl<CreateChallengeAgreement.Presenter, CreateChallengeAgreement.View>(R.layout.fragment_create_challenge),
    CreateChallengeAgreement.View {
    override fun challengeCreated() {
        finish()
    }

    override fun setupInputs() {
        Observable.combineLatest(
            RxTextView.textChanges(titleEditText),
            RxTextView.textChanges(descriptionEditText),
            BiFunction { t1: CharSequence, t2: CharSequence -> t1 to t2 }
        )
            .subscribe { (title, description) ->
                btnCreateChallenge.isEnabled = title.isNotBlank() && description.isNotBlank()
            }.disposeByBagProvider()

        btnCreateChallenge.bindClick {
            presenter.createChallenge(titleEditText.text.toString(), descriptionEditText.text.toString())
        }
    }

    override fun returnThisHerePlease(): CreateChallengeAgreement.View = this

    override fun showLoading() {
        // TODO
    }

    override fun hideLoading() {
        // TODO
    }

}