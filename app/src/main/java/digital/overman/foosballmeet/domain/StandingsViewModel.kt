package digital.overman.foosballmeet.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import digital.overman.foosballmeet.data.Match
import digital.overman.foosballmeet.data.PlayersRepository
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlin.random.Random

const val TAG = "StandingsViewModel"
class StandingsViewModel : ViewModel() {
    var repository = PlayersRepository
    private val _players = MutableLiveData("loading...")
    val players: LiveData<String>
        get() = _players

    private val _dumby = MutableLiveData(0)
    val dumby: LiveData<Int>
        get() = _dumby
//        get() = players.joinToString(separator = " \n")
    init {
        viewModelScope.launch {
            repository.playerList
                .distinctUntilChanged()
                .collect { list ->
                Log.d(TAG, "player list collected")
                _players.value = list.joinToString(separator = "\n")
            }
        }
    }

    fun getPlayerList() {
    }
    fun addMatchClicked() {
        val match = Match("Ada", Random.nextInt(0,8), "Dad", Random.nextInt(2,10))
        repository.addMatch(match)
        Log.d(TAG, "Repository has ${repository.matches.size} matches")
//        getPlayerList()
        _players.value = repository.getPlayersSortedByComparator().joinToString(separator = "\n")
        _dumby.value = _dumby.value?.inc()
        Log.d(TAG, "_Dumby: ${_dumby.value.toString()}")
        Log.d(TAG, "Dumby: ${dumby.value.toString()}")
    }

}