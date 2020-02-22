package com.afkoders.hackathon.data.repository

import com.afkoders.hackathon.data.service.ApiService
import com.afkoders.hackathon.di.qualifiers.SchedulerIO
import com.afkoders.hackathon.di.qualifiers.SchedulerUI
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: ApiService,
                                         @SchedulerUI private val schedulerUI: Scheduler,
                                         @SchedulerIO private val schedulerIO: Scheduler) : Repository {

    override fun getTestData(): Single<List<String>> =
        Single.just(listOf("Fuck", "Fuck1", "FuckN"))
            .subscribeOn(schedulerIO)
            .observeOn(schedulerUI)

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