package digital.overman.foosballmeet.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import digital.overman.foosballmeet.data.Match
import digital.overman.foosballmeet.data.Player
import digital.overman.foosballmeet.data.PlayersRepository
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

const val TAG = "StandingsViewModel"
class StandingsViewModel : ViewModel() {
    var repository = PlayersRepository
    private val _players = MutableLiveData(emptyList<Player>())
    val players: LiveData<List<Player>>
        get() = _players

//    init {
//        viewModelScope.launch {
//            repository.playerList
//                .distinctUntilChanged()
//                .collect { list ->
//                Log.d(TAG, "player list collected")
//                _players.value = list
//            }
//        }
//    }

    fun getPlayerList(): List<Player> {
        return repository.getPlayersSortedByComparator()
    }
//    fun addButtonClicked() {
//        val match = Match("Ada", Random.nextInt(0,8), "Dad", Random.nextInt(2,10))
//        repository.addMatch(match)
//        Log.d(TAG, "Repository has ${repository.matches.size} matches")
////        getPlayerList()
//        _players.value = repository.getPlayersSortedByComparator().joinToString(separator = "\n")
//        _dumby.value = _dumby.value?.inc()
//        Log.d(TAG, "_Dumby: ${_dumby.value.toString()}")
//        Log.d(TAG, "Dumby: ${dumby.value.toString()}")
//    }

    fun addMatch(match: Match) {
        Log.d(TAG, "adding match to repo")
        repository.addMatch(match)
        _players.value = repository.getPlayersSortedByComparator()
    }
}