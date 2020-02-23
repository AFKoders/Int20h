package com.afkoders.batteryme.presentation.challenges

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.afkoders.batteryme.R
import com.afkoders.batteryme.presentation.base.BaseFragmentImpl
import com.afkoders.batteryme.presentation.challenges.list.ChallengeRecyclerAdapter
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.main.MainFragment
import com.afkoders.batteryme.utils.extensions.show
import com.afkoders.batteryme.utils.extensions.widget.makeGone
import com.afkoders.batteryme.utils.extensions.widget.makeVisible
import kotlinx.android.synthetic.main.fragment_challenges.*
import javax.inject.Inject

class ChallengesFragment :
    BaseFragmentImpl<ChallengesAgreement.Presenter, ChallengesAgreement.View>(R.layout.fragment_challenges),
    ChallengesAgreement.View {
    @Inject
    lateinit var adapter: ChallengeRecyclerAdapter

    override fun setupInputs() {
        rvChallenges.itemAnimator = DefaultItemAnimator()
        rvChallenges.adapter = adapter
        rvChallenges.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0 && fabNewChallenge.isShown) {
                    fabNewChallenge.hide()
                } else if (dy < 0) {
                    fabNewChallenge.show()
                }
            }
        })

        swipeRefreshLayoutChallenges.setOnRefreshListener {
            presenter.uploadData()
        }

        adapter.challengeClickedObservable
            .subscribe {
                (parentFragment as MainFragment).navigateToChallengeDetails(it)
            }.disposeByBagProvider()

        fabNewChallenge.bindClick {
            // TODO
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.uploadData()
    }

    override fun showLoading() {
        swipeRefreshLayoutChallenges.makeGone()
        progress.show(parentFragmentManager)
    }

    override fun hideLoading() {
        progress.dismiss()
        swipeRefreshLayoutChallenges.makeVisible()
    }

    override fun populateData(data: List<AdapterDelegateItem>) {
        swipeRefreshLayoutChallenges.isRefreshing = false
        adapter.clearAndAddAll(data)
    }

    override fun returnThisHerePlease(): ChallengesAgreement.View = this
}