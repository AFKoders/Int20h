package com.afkoders.batteryme.presentation.test

import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.utils.extensions.show
import com.afkoders.batteryme.utils.extensions.widget.makeGone
import com.afkoders.batteryme.utils.extensions.widget.makeVisible
import kotlinx.android.synthetic.main.fragment_test.*

class TestFragment :
    BaseFragmentImpl<TestAgreement.Presenter, TestAgreement.View>(R.layout.fragment_test),
    TestAgreement.View {
    override fun setupInputs() {
        button.bindClick { presenter.loadData() }
    }

    override fun showLoading() {
        gView.makeGone()
        progress.show(parentFragmentManager)
    }

    override fun hideLoading() {
        progress.dismiss()
        gView.makeVisible()
    }

    override fun populateData(data: List<String>) {
        textView.text = data.toString()
    }

    override fun showError() {
        // Nothing
    }

    override fun returnThisHerePlease(): TestAgreement.View = this

}