package com.afkoders.batteryme.data.exception

import java.io.IOException

class NoResultException : IOException() {
    override val message: String
        get() = "No result from server exception"
}