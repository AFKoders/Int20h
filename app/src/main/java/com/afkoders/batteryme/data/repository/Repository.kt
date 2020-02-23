package com.afkoders.batteryme.data.repository

import com.afkoders.batteryme.presentation.challenges.model.Challenge
import com.afkoders.batteryme.presentation.common.models.User
import com.afkoders.batteryme.presentation.events.model.Event
import io.reactivex.Single

interface Repository {
    //fun findSongByTitle(fullTitle: String): Single<DeezerSong>

    fun getTestData(): Single<List<String>>

    fun addUserRemote(user: User)

    fun addChallengeRemote(challenge: Challenge)

    fun addEventRemote(event: Event)

    fun addUserToChallenge(user: User, challengeId: Long)

    fun addUserToEvent(user: User, eventId: Long)

    fun getAllEvents(block: (event: List<Event>) -> Unit)

    fun getAllChallenges(block: (challenges: List<Challenge>) -> Unit)

    fun getAllUsers(block: (users: List<User>) -> Unit)

    fun removeUserFromEvent(user: User, eventId: Long)

    fun removeUserFromChallenge(user: User, challengeId: Long)
}