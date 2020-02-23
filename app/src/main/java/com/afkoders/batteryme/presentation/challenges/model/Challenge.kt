package com.afkoders.batteryme.presentation.challenges.model

import com.afkoders.batteryme.presentation.common.models.User
import java.io.Serializable
import java.util.*

data class Challenge(
    val title: String = "",
    val description: String = "",
    val users: MutableList<User> = mutableListOf(),
    val id: Long = Date().time
): Serializable