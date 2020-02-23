package com.afkoders.batteryme.presentation.challenges

import com.afkoders.batteryme.data.prefs.AppPrefs
import com.afkoders.batteryme.data.repository.Repository
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.common.models.HeaderItem
import javax.inject.Inject

class ChallengesPresenter @Inject constructor(
    private val repository: Repository,
    private val appPrefs: AppPrefs
) :
    BasePresenterImpl<List<AdapterDelegateItem>, ChallengesAgreement.View>(),
    ChallengesAgreement.Presenter {

    override fun uploadData() {
        repository.getAllChallenges { challenges ->
            val myChallenges = challenges
                .filter { it.users.any { it.id == appPrefs.user.id } }.map {
                    AdapterDelegateItem.Model(
                        it
                    )
                }

            val allChallenges = challenges
                .filter { it.users.none { it.id == appPrefs.user.id } }.map {
                    AdapterDelegateItem.Model(
                        it
                    )
                }

            val result = if(myChallenges.isNotEmpty()) {
                mutableListOf(HeaderItem("My challenges")).plus(myChallenges)
            } else {
                listOf()
            }.plus(
                if(allChallenges.isNotEmpty()) {
                    mutableListOf(HeaderItem("All challenges")).plus(allChallenges)
                } else {
                    listOf()
                }
            )

            model = result
            view?.populateData(result)
        }
    }
}