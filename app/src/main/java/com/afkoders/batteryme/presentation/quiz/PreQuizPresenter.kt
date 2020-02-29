package com.afkoders.batteryme.presentation.quiz

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import javax.inject.Inject

class PreQuizPresenter (private val appPrefs: AppPrefs) :
    BasePresenterImpl<String, PreQuizAgreement.View>(),
    PreQuizAgreement.Presenter {

}