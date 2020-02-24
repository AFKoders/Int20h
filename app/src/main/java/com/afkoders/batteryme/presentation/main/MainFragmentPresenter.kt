package com.afkoders.batteryme.presentation.main

import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import javax.inject.Inject


class MainFragmentPresenter @Inject constructor() :
    BasePresenterImpl<Unit, MainFragmentAgreement.View>(),
    MainFragmentAgreement.Presenter