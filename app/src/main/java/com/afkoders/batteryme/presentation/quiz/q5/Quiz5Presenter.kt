package com.afkoders.batteryme.presentation.quiz.q5

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import javax.inject.Inject

class Quiz5Presenter @Inject constructor(private val appPrefs: AppPrefs) :
    BasePresenterImpl<String, Quiz5Agreement.View>(),
    Quiz5Agreement.Presenter {

}