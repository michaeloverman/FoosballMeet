package digital.overman.foosballmeet.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import digital.overman.foosballmeet.data.Match
import digital.overman.foosballmeet.data.Player
import digital.overman.foosballmeet.data.PlayersRepository

const val TAG = "StandingsViewModel"
class StandingsViewModel(private val repository: PlayersRepository): ViewModel() {
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

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return StandingsViewModel(PlayersRepository) as T
            }
        }
    }
}