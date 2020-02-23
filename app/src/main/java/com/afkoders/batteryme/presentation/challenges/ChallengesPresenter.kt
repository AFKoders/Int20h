package com.afkoders.batteryme.presentation.challenges

import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.challenges.model.Challenge
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.common.models.HeaderItem
import com.afkoders.batteryme.presentation.common.models.User
import com.afkoders.batteryme.presentation.events.model.Event
import java.util.*
import javax.inject.Inject

class ChallengesPresenter @Inject constructor() :
    BasePresenterImpl<List<AdapterDelegateItem>, ChallengesAgreement.View>(),
    ChallengesAgreement.Presenter {

    override fun uploadData() {
        // TODO fetch data from firebase
        val myChallenges = listOf(
            Challenge("title1", "description1", mutableListOf(
                        User("", "", "", "", "", null, 0)
            )),
            Challenge("title2", "description2", mutableListOf())
        )
        val allChallenges = listOf(
            Challenge("title1", "description1", mutableListOf(
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null)
            )),
            Challenge("title2", "description2", mutableListOf()),
            Challenge("title3", "description4", mutableListOf(
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null),
                User("", "", "", "", "", null)
            ))
        )

        model = listOf(HeaderItem("My challenges"))
            .plus(myChallenges.map { AdapterDelegateItem.Model(it) })
            .plus(HeaderItem("All challenges"))
            .plus(allChallenges.map { AdapterDelegateItem.Model(it) })

        view?.populateData(model as List<AdapterDelegateItem>)
    }
}