package com.afkoders.batteryme.presentation.leaderboard

import com.afkoders.batteryme.data.repository.Repository
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.common.models.HeaderItem
import com.afkoders.batteryme.presentation.leaderboard.model.LeaderboardModel
import javax.inject.Inject

class LeaderboardPresenter @Inject constructor(private val repository: Repository) :
    BasePresenterImpl<List<AdapterDelegateItem>, LeaderboardAgreement.View>(),
    LeaderboardAgreement.Presenter {
    override fun uploadData() {
        repository.getAllUsers { users ->
            view?.populateData(listOf(HeaderItem("Chargeboard")).plus(users.map {
                LeaderboardModel(
                    it.photo,
                    it.givenName,
                    it.score
                )
            }
                .sortedByDescending { it.score }
                .map { AdapterDelegateItem.Model(it) }
            ))
        }

    }

}