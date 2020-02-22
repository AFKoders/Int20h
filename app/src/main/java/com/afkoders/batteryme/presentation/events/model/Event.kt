package com.afkoders.batteryme.presentation.events.model

import com.afkoders.batteryme.presentation.common.models.User
import java.util.*

data class Event(
    val title: String,
    val description: String,
    val dateTime: Date,
    val location: String,
    val users: List<User>
)