package com.afkoders.batteryme.utils.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes


fun ViewGroup.inflateWithoutAttach(@LayoutRes resId: Int): View =
    LayoutInflater.from(context).inflate(resId, this, false)

fun LayoutInflater.inflateWithoutAttach(parent: ViewGroup?, @LayoutRes resId: Int): View? =
    inflate(resId, parent, false)