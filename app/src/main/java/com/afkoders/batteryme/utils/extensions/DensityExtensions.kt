package com.afkoders.batteryme.utils.extensions

import android.content.Context
import kotlin.math.round


fun Double.toDp(context: Context): Float {
    val density = context.resources.displayMetrics.density
    return round(this * density).toFloat()
}