package com.afkoders.batteryme.presentation.main

import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import io.reactivex.Observable
import javax.inject.Inject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.xml.datatype.DatatypeConstants.SECONDS




class MainFragmentPresenter @Inject constructor():
    BasePresenterImpl<Unit /* TODO change model here */, MainFragmentAgreement.View>(),
    MainFragmentAgreement.Presenter {
}