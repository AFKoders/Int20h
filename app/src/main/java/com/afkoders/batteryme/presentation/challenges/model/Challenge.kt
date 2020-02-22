package com.afkoders.batteryme.presentation.challenges.model

import com.afkoders.batteryme.presentation.common.models.User

data class Challenge(
    val title: String,
    val description: String,
    val users: List<User>
)