package com.afkoders.hackathon.utils.extensions

import android.app.Activity
import android.app.Dialog
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.afkoders.hackathon.R
import com.afkoders.hackathon.presentation.dialogs.BaseDialog
import kotlin.math.min
import kotlin.math.roundToInt


fun <T : BaseDialog> T.show(manager: FragmentManager): T =
    this.also { it.show(manager, it::class.java.simpleName) }

fun Dialog.setWidthRelativeToParent(activity: Activity?, percentage: Int) {
    val screen = activity ?: return

    val defaultDialogWidth = screen.resources.getDimension(R.dimen.default_width_of_dialog)
    val dynamicWidth = (percentage / 100.0f * screen.getMinWidthValue())

    val calculatedDialogWidth = min(defaultDialogWidth, dynamicWidth).roundToInt()
    window?.setLayout(calculatedDialogWidth, ViewGroup.LayoutParams.WRAP_CONTENT)
}