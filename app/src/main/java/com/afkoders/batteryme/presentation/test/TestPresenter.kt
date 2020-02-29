package com.afkoders.batteryme.presentation.test

import com.afkoders.batteryme.data.repository.Repository
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class TestPresenter  (private val repository: Repository) :
    BasePresenterImpl<MutableList<String>, TestAgreement.View>(), TestAgreement.Presenter {

    override fun loadData() {
        repository.getTestData()
            .delay(2000, TimeUnit.MILLISECONDS)
            .bindLoading()
            .subscribe({
                model?.addAll(it)
                view?.populateData(it)
            }, {
                view?.showError()
            }).disposeByBagProvider()
    }
}