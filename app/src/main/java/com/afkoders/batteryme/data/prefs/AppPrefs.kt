package com.afkoders.batteryme.data.prefs

import android.content.Context
import com.afkoders.batteryme.presentation.common.models.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class AppPrefs constructor(context: Context, private val gson: Gson) {

    companion object {
        private const val HISTORY_PREFS = "history_prefs"
        private const val USER_PREF = "USER_PREF"
        private const val IS_USERED_PASSED_QUIZ = "isUserPassedQuiz"
    }

    private val prefs =
        context.getSharedPreferences(HISTORY_PREFS, Context.MODE_PRIVATE)


    fun putUser(userAdd: User) {
        user = userAdd
    }

    fun setUserPassedQuiz(isPassed: Boolean){
        prefs.edit().putBoolean(IS_USERED_PASSED_QUIZ, isPassed).apply()
    }

    fun isUserPassedQuiz(): Boolean {
        return prefs.getBoolean(IS_USERED_PASSED_QUIZ, false)
    }

    var user: User
        set(value) = prefs.edit().putString(USER_PREF, gson.toJson(value)).apply()
        get() = gson.fromJson(
            prefs.getString(USER_PREF, ""),
            object : TypeToken<User>() {}.type
        ) ?: User("", "", "", "", "", "", 0)

    fun clear() {
        prefs.edit().clear().apply()
    }
}