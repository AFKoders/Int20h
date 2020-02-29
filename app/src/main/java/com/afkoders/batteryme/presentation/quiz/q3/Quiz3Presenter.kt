package com.afkoders.batteryme.presentation.quiz.q3

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import javax.inject.Inject

class Quiz3Presenter (private val appPrefs: AppPrefs) :
    BasePresenterImpl<String, Quiz3Agreement.View>(),
    Quiz3Agreement.Presenter {

}