package com.afkoders.batteryme.presentation.leaderboard

import com.afkoders.batteryme.data.repository.Repository
import com.afkoders.batteryme.presentation.base.BasePresenterImpl
import com.afkoders.batteryme.presentation.common.models.AdapterDelegateItem
import com.afkoders.batteryme.presentation.leaderboard.model.LeaderboardModel
import javax.inject.Inject

class LeaderboardPresenter @Inject constructor(private val repository: Repository) :
    BasePresenterImpl<List<AdapterDelegateItem>, LeaderboardAgreement.View>(),
    LeaderboardAgreement.Presenter {
    override fun uploadData() {
        // TODO fetch data from firebase
        /* val leaderboard = listOf(
             LeaderboardModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Fknowyourmeme.com%2Fmemes%2Fpeople%2Fgeneric-indian-guy%2Fvideos%2Ftrending&psig=AOvVaw1XcsyiLEgkA7mPmeaj5eiD&ust=1582490352496000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLCbuYyC5ucCFQAAAAAdAAAAABAD", "name1", 74),
             LeaderboardModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Fknowyourmeme.com%2Fmemes%2Fpeople%2Fgeneric-indian-guy%2Fvideos%2Ftrending&psig=AOvVaw1XcsyiLEgkA7mPmeaj5eiD&ust=1582490352496000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLCbuYyC5ucCFQAAAAAdAAAAABAD", "name2", 92),
             LeaderboardModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Fknowyourmeme.com%2Fmemes%2Fpeople%2Fgeneric-indian-guy%2Fvideos%2Ftrending&psig=AOvVaw1XcsyiLEgkA7mPmeaj5eiD&ust=1582490352496000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLCbuYyC5ucCFQAAAAAdAAAAABAD", "name3", 22),
             LeaderboardModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Fknowyourmeme.com%2Fmemes%2Fpeople%2Fgeneric-indian-guy%2Fvideos%2Ftrending&psig=AOvVaw1XcsyiLEgkA7mPmeaj5eiD&ust=1582490352496000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLCbuYyC5ucCFQAAAAAdAAAAABAD", "name4", 44),
             LeaderboardModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Fknowyourmeme.com%2Fmemes%2Fpeople%2Fgeneric-indian-guy%2Fvideos%2Ftrending&psig=AOvVaw1XcsyiLEgkA7mPmeaj5eiD&ust=1582490352496000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLCbuYyC5ucCFQAAAAAdAAAAABAD", "name5", 96),
             LeaderboardModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Fknowyourmeme.com%2Fmemes%2Fpeople%2Fgeneric-indian-guy%2Fvideos%2Ftrending&psig=AOvVaw1XcsyiLEgkA7mPmeaj5eiD&ust=1582490352496000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLCbuYyC5ucCFQAAAAAdAAAAABAD", "name6", 51),
             LeaderboardModel("https://www.google.com/url?sa=i&url=https%3A%2F%2Fknowyourmeme.com%2Fmemes%2Fpeople%2Fgeneric-indian-guy%2Fvideos%2Ftrending&psig=AOvVaw1XcsyiLEgkA7mPmeaj5eiD&ust=1582490352496000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLCbuYyC5ucCFQAAAAAdAAAAABAD", "name7", 88)
         )
         model = listOf(HeaderItem("Leaderboard"))
             .plus(leaderboard.map { AdapterDelegateItem.Model(it) })
 */
        repository.getAllUsers { users ->
            view?.populateData(users.map {
                AdapterDelegateItem.Model(
                    LeaderboardModel(
                        it.photo,
                        it.name,
                        it.score
                    )
                )
            })
        }

    }

}