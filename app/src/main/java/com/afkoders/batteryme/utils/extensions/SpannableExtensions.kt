package com.afkoders.batteryme.utils.extensions

import android.text.SpannableString


fun SpannableString.spanWith(target: String, apply: SpannableBuilder.() -> Unit): SpannableString {
    val builder = SpannableBuilder()
    apply(builder)

    val start = this.indexOf(target)
    val end = start + target.length

    builder.whats?.let {
        it.forEach {
            setSpan(it, start, end, builder.flags)
        }
    }

    builder.what?.let {
        setSpan(it, start, end, builder.flags)
    }

    return this
}

class SpannableBuilder {
    var what: Any? = null
    var whats: List<Any>? = null
    var flags: Int = 0
}