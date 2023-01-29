package digital.overman.foosballmeet.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import digital.overman.foosballmeet.data.Match
import digital.overman.foosballmeet.data.Player
import digital.overman.foosballmeet.data.PlayersRepository
import javax.inject.Inject

const val TAG = "StandingsViewModel"
class StandingsViewModel : ViewModel() {
    @Inject
    var repository = PlayersRepository
    private val _players = MutableLiveData(emptyList<Player>())
    val players: LiveData<List<Player>>
        get() = _players

    fun getPlayerList(): List<Player> {
        return repository.getPlayersSortedByComparator()
    }

    fun addMatch(match: Match) {
        Log.d(TAG, "adding match to repo")
        repository.addMatch(match)
        _players.value = repository.getPlayersSortedByComparator()
    }
}