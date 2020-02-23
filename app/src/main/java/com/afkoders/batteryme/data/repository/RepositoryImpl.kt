package com.afkoders.batteryme.data.repository

import com.afkoders.batteryme.data.service.ApiService
import com.afkoders.batteryme.di.qualifiers.SchedulerIO
import com.afkoders.batteryme.di.qualifiers.SchedulerUI
import com.afkoders.batteryme.presentation.challenges.model.Challenge
import com.afkoders.batteryme.presentation.common.models.User
import com.afkoders.batteryme.presentation.events.model.Event
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import io.reactivex.Scheduler
import io.reactivex.Single
import java.util.*
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    @SchedulerUI private val schedulerUI: Scheduler,
    @SchedulerIO private val schedulerIO: Scheduler
) : Repository {

    val database = FirebaseDatabase.getInstance().reference

    override fun getTestData(): Single<List<String>> {
        return Single.just(listOf("Fuck", "Fuck1", "FuckN"))
            .subscribeOn(schedulerIO)
            .observeOn(schedulerUI)

    }

    override fun addChallengeRemote(challenge: Challenge) {
        val usersOf = mutableListOf<User>()
        usersOf.addAll(challenge.users)
        challenge.users.clear()
        database.child("Challenges").child(challenge.id.toString()).setValue(challenge)
        for (userSpec in usersOf) {
            database.child("Challenges").child(challenge.id.toString()).child("Users")
                .child(userSpec.id)
                .setValue(userSpec)
        }
    }

    override fun addUserRemote(user: User) {
        database.child("Users").child(user.id).setValue(user)
    }

    override fun addEventRemote(event: Event) {
        database.child("Events").child(event.id.toString()).setValue(event)
        val usersOf = mutableListOf<User>()
        usersOf.addAll(event.users)
        event.users.clear()
        for (userSpec in usersOf) {
            database.child("Events").child(event.id.toString()).child("Users").child(userSpec.id)
                .setValue(userSpec)
        }
    }

    override fun addUserToChallenge(user: User, challengeId: Long) {
        database.child("Challenges").child(challengeId.toString()).child("Users").child(user.id)
            .setValue(user)
    }

    override fun addUserToEvent(user: User, eventId: Long) {
        database.child("Event").child(eventId.toString()).child("Users").child(user.id)
            .setValue(user)
    }


    override fun getAllChallenges(block: (challenges: List<Challenge>) -> Unit) {
        database.child("Challenges").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                val challenges: MutableList<Challenge> = mutableListOf()
                //Log.d("chacha", snapshot.toString())
                for (snap in snapshot.children) {


                    val usersForChallenge: MutableList<User> = mutableListOf()
                    val usersSnap = snap.child("Users")
                    for (userSnap in usersSnap.children) {
                        usersForChallenge.add(userSnap.getValue(User::class.java) ?: User())
                    }
                    val newChalleng = snap.getValue(Challenge::class.java) ?: Challenge(
                        "title",
                        "desc",
                        mutableListOf()
                    )
                    newChalleng.users.addAll(usersForChallenge)
                    challenges.add(newChalleng)

                }

                block.invoke(challenges)
            }

        })
    }

    override fun getAllEvents(block: (event: List<Event>) -> Unit) {
        database.child("Events").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                val events: MutableList<Event> = mutableListOf()

                for (snap in snapshot.children) {

                    val usersForEvent: MutableList<User> = mutableListOf()
                    val usersSnap = snap.child("Users")
                    for (userSnap in usersSnap.children) {
                        usersForEvent.add(userSnap.getValue(User::class.java) ?: User())
                    }
                    val newEvent = snap.getValue(Event::class.java) ?: Event()
                    newEvent.users.addAll(usersForEvent)
                    events.add(newEvent)


                }

                block.invoke(events)
            }

        })
    }

    override fun getAllUsers(block: (users: List<User>) -> Unit) {
        database.child("Users").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                val users: MutableList<User> = mutableListOf()

                for (snap in snapshot.children) {
                    users.add(snap.getValue(User::class.java) ?: User())
                }

                block.invoke(users)
            }
        })
    }

    override fun removeUserFromChallenge(user: User, challengeId: Long) {
        database.child("Challenges").child(challengeId.toString()).child("Users").child(user.id)
            .removeValue()    }

    override fun removeUserFromEvent(user: User, eventId: Long) {
        database.child("Events").child(eventId.toString()).child("Users").child(user.id)
            .removeValue()    }
    /*override fun findSongByTitle(fullTitle: String): Single<DeezerSong> {
        return apiService.findByArtistAndTrack(fullTitle)
            .map {
                if (!it.deezerSongs.isNullOrEmpty()) {
                    it.deezerSongs[0]
                } else {
                    throw NoResultException()
                }
            }
    }*/
}