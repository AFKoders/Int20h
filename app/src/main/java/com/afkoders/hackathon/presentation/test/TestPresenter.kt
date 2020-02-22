package com.afkoders.hackathon.presentation.test

import com.afkoders.hackathon.data.repository.Repository
import com.afkoders.hackathon.presentation.base.BasePresenterImpl
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class TestPresenter @Inject constructor(private val repository: Repository) :
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