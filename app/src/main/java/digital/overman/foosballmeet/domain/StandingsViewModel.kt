package digital.overman.foosballmeet.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import digital.overman.foosballmeet.data.Match
import digital.overman.foosballmeet.data.Player
import digital.overman.foosballmeet.data.PlayersRepository
import javax.inject.Inject

const val TAG = "StandingsViewModel"
@HiltViewModel
class StandingsViewModel @Inject constructor(private val repository: PlayersRepository): ViewModel() {
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