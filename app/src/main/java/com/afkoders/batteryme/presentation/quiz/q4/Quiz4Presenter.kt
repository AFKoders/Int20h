package com.afkoders.batteryme.presentation.quiz.q4

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import javax.inject.Inject

class Quiz4Presenter @Inject constructor(private val appPrefs: AppPrefs) :
    BasePresenterImpl<String, Quiz4Agreement.View>(),
    Quiz4Agreement.Presenter {

}