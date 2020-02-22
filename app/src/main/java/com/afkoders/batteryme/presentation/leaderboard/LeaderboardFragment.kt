package com.afkoders.batteryme.presentation.leaderboard

import androidx.recyclerview.widget.DefaultItemAnimator
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.leaderboard.list.LeaderboardRecyclerAdapter
import com.afkoders.batteryme.utils.extensions.show
import com.afkoders.batteryme.utils.extensions.widget.makeGone
import com.afkoders.batteryme.utils.extensions.widget.makeVisible
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

        swipeRefreshLayoutLeaderboard.setOnRefreshListener {
            presenter.uploadData()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.uploadData()
    }

    override fun populateData(data: List<AdapterDelegateItem>) {
        swipeRefreshLayoutLeaderboard.isRefreshing = false
        adapter.clearAndAddAll(data)
    }

    override fun showLoading() {
        swipeRefreshLayoutLeaderboard.makeGone()
        progress.show(parentFragmentManager)
    }

    override fun hideLoading() {
        progress.dismiss()
        swipeRefreshLayoutLeaderboard.makeVisible()
    }

    override fun returnThisHerePlease(): LeaderboardAgreement.View = this
}