package com.afkoders.hackathon.utils.extensions.widget

import android.view.inputmethod.EditorInfo
import androidx.appcompat.widget.AppCompatEditText


fun AppCompatEditText.addSearchWatcher(block: () -> Unit) {
    this.setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            block.invoke()
        }
        true
    }
}