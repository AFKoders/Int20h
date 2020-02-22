package com.afkoders.batteryme.utils.extensions

import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior


fun <V : View> BottomSheetBehavior<V>.expand() {
    state = BottomSheetBehavior.STATE_EXPANDED
}

fun <V : View> BottomSheetBehavior<V>.collapse() {
    state = BottomSheetBehavior.STATE_COLLAPSED
}

fun <V : View> BottomSheetBehavior<V>.hide() {
    state = BottomSheetBehavior.STATE_HIDDEN
}