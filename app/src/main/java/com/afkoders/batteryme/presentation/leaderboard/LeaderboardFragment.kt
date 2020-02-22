package com.afkoders.batteryme.presentation.leaderboard

import androidx.recyclerview.widget.DefaultItemAnimator
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.leaderboard.list.LeaderboardRecyclerAdapter
import com.afkoders.batteryme.presentation.leaderboard.model.LeaderboardModel
import kotlinx.android.synthetic.main.fragment_leaderboard.*
import javax.inject.Inject

class LeaderboardFragment :
    BaseFragmentImpl<LeaderboardAgreement.Presenter, LeaderboardAgreement.View>(R.layout.fragment_leaderboard),
    LeaderboardAgreement.View {

    @Inject
    lateinit var adapter: LeaderboardRecyclerAdapter

    override fun setupInputs() {

        rvLeaderboard.itemAnimator = DefaultItemAnimator()
        rvLeaderboard.adapter = adapter



        adapter.smthClickedObservable
            .subscribe {
                // TODO open something
            }.disposeByBagProvider()

        adapter.addAll(getTestData())

    }

    private fun getTestData(): List<AdapterDelegateItem> {
       return  listOf(
            LeaderboardModel("https://", "name", 88),
            LeaderboardModel("https://", "name", 88),
            LeaderboardModel("https://", "name", 88),
            LeaderboardModel("https://", "name", 88),
            LeaderboardModel("https://", "name", 88),
            LeaderboardModel("https://", "name", 88),
            LeaderboardModel("https://", "name", 88)
            ).map{
            AdapterDelegateItem.Model(it)
        }
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun returnThisHerePlease(): LeaderboardAgreement.View = this
}