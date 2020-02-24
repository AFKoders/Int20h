package com.afkoders.batteryme.utils.extensions

import android.content.Context
import kotlin.math.round


fun Int.dp(context: Context): Int = (this * context.resources.displayMetrics.density).toInt()

fun Int.sp(context: Context): Int = (this * context.resources.displayMetrics.scaledDensity).toInt()