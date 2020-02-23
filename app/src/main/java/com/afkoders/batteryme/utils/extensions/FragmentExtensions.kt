package com.afkoders.batteryme.utils.extensions

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment


fun Fragment.finish(@IdRes destinationId: Int? = null, inclusive: Boolean = false) {
    with((parentFragment as NavHostFragment).navController) {
        if (destinationId != null) {
            popBackStack(destinationId, inclusive)
        } else {
            popBackStack()
        }
    }
}

inline fun NavController.navigateTo(@IdRes destinationId: Int, block: Bundle.() -> Unit = {}) {
    val action = currentDestination?.getAction(destinationId) ?: graph.getAction(destinationId)
    if (action != null && currentDestination?.id != action.destinationId) {
        navigate(destinationId, Bundle().apply { block() })
    }
}