package com.afkoders.batteryme.utils.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.format(): String =
  SimpleDateFormat("EEE, d MMM HH:mm", Locale.getDefault()).format(this)

