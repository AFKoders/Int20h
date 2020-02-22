package com.afkoders.batteryme.presentation.dialogs.builders

import android.os.Bundle
import com.afkoders.batteryme.presentation.dialogs.ConfirmationDialog


abstract class DialogBuilder {
    var args = Bundle()

    var widthPercentage: Int = 90
    var isCancelableOnTouchOutside: Boolean = true
    var shouldClearDim: Boolean = false

    fun args(block: Bundle.() -> Unit = {}) {
        args = Bundle().apply(block)
    }
}

abstract class SingleCtaDialogBuilder : DialogBuilder() {
    var title: String = ""
    var message: String = ""
    var actionPositiveText: String = ""
}

abstract class DoubleCtaDialogBuilder : SingleCtaDialogBuilder() {
    var actionNegativeText: String = ""
}

abstract class ListDialogBuilder<T> : SingleCtaDialogBuilder() {
    val items: MutableList<T> = mutableListOf()
}

class ConfirmationDialogBuilder : DoubleCtaDialogBuilder() {
    var listener: ConfirmationDialog.Listener? = null
}

class LoaderDialogBuilder : DialogBuilder()