package com.afkoders.batteryme.presentation.events.model

import com.afkoders.batteryme.presentation.common.models.User
import java.io.Serializable
import java.util.*

data class Event(
    val title: String = "",
    val description: String = "",
    val dateTime: Date = Date(),
    val location: String = "",
    val users: MutableList<User> = mutableListOf(),
    val id: Long = Date().time
): Serializable