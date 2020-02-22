package com.afkoders.batteryme.presentation.common.models

import android.net.Uri

data class User(
    val name: String,
    val givenName: String,
    val familyName: String,
    val email: String,
    val id: String,
    val photo: Uri
)