package com.afkoders.batteryme.presentation.quiz.q2

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import javax.inject.Inject

class Quiz2Presenter @Inject constructor(private val appPrefs: AppPrefs) :
    BasePresenterImpl<String, Quiz2Agreement.View>(),
    Quiz2Agreement.Presenter {

}