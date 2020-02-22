package com.afkoders.batteryme.data.prefs

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class AppPrefs constructor(context: Context, private val gson: Gson) {

    companion object {
        private const val HISTORY_PREFS = "history_prefs"
        private const val USER_PREF = "USER_PREF"
    }

    private val prefs =
        context.getSharedPreferences(HISTORY_PREFS, Context.MODE_PRIVATE)


    fun putUser(userAdd: String) {
       user = userAdd
   }

   var user: String
       set(value) = prefs.edit().putString(USER_PREF, gson.toJson(value)).apply()
       get() = gson.fromJson(
           prefs.getString(USER_PREF, ""),
           object : TypeToken<String>() {}.type
       ) ?: ""

    /*fun addToHistory(track: History) {
        val newList = history
        newList.add(track)
        history = newList
    }

    var history: MutableList<History>
        set(value) = prefs.edit().putString(HISTORY_LIST, gson.toJson(value)).apply()
        get() = gson.fromJson(
            prefs.getString(HISTORY_LIST, ""),
            object : TypeToken<List<History>>() {}.type
        ) ?: mutableListOf()*/

    fun clear() {
        prefs.edit().clear().apply()
    }
}