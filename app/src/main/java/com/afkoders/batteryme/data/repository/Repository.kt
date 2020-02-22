package com.afkoders.batteryme.data.repository

import io.reactivex.Single

interface Repository {
    //fun findSongByTitle(fullTitle: String): Single<DeezerSong>

    fun getTestData(): Single<List<String>>
}