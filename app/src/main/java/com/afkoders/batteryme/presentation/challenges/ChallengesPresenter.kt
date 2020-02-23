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

        /*
        val myChallenges = listOf(
            Challenge(
                "title1", "description1", mutableListOf(
                    User("", "", "", "", "", "", 0)
                )
            ),
            Challenge("title2", "description2", mutableListOf())
        )
        val allChallenges = listOf(
            Challenge(
                "title1", "description1", mutableListOf(
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", "")
                )
            ),
            Challenge("title2", "description2", mutableListOf()),
            Challenge(
                "title3", "description4", mutableListOf(
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", ""),
                    User("", "", "", "", "", "")
                )
            )
        )

        model = listOf(HeaderItem("My challenges"))
            .plus(myChallenges.map { AdapterDelegateItem.Model(it) })
            .plus(HeaderItem("All challenges"))
            .plus(allChallenges.map { AdapterDelegateItem.Model(it) })
*/
        repository.getAllChallenges { challenges ->
            view?.populateData(mutableListOf(HeaderItem("My challenges"))
                .plus(challenges
                    .filter { it.users.any { it.id == appPrefs.user.id } }.map {
                        AdapterDelegateItem.Model(
                            it
                        )
                    }).plus(mutableListOf(HeaderItem("All challenges")).plus(challenges
                    .filter { it.users.none { it.id == appPrefs.user.id } }.map {
                        AdapterDelegateItem.Model(
                            it
                        )
                    })
                )
            )
        }

    }
}