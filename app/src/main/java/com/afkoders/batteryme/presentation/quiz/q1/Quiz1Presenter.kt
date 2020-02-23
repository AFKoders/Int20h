package com.afkoders.batteryme.presentation.quiz.q1

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import javax.inject.Inject

class Quiz1Presenter @Inject constructor(private val appPrefs: AppPrefs) :
    BasePresenterImpl<String, Quiz1Agreement.View>(),
    Quiz1Agreement.Presenter {

}