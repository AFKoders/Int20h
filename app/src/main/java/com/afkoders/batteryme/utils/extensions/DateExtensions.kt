package com.afkoders.batteryme.utils.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.format(): String =
  SimpleDateFormat("EEE, d MMM HH:mm", Locale.getDefault()).format(this)

fun Date.formatShortDate(): String =
  SimpleDateFormat("d\nEEE", Locale.getDefault()).format(this)

fun Date.formatEventDate(): String =
  SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault()).format(this)

fun Date.formatEventTime(): String =
  SimpleDateFormat("HH:mm", Locale.getDefault()).format(this)

fun Date.formatMonth(): String =
  SimpleDateFormat("MMM", Locale.getDefault()).format(this)

