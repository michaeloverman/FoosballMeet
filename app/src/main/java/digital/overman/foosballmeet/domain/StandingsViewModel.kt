package digital.overman.foosballmeet.domain

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import digital.overman.foosballmeet.data.Match
import digital.overman.foosballmeet.data.PlayersRepository
import kotlin.random.Random

const val TAG = "StandingsViewModel"
class StandingsViewModel : ViewModel() {
    var repository = PlayersRepository
//    private val _players = MutableLiveData("loading...")
//    val players: LiveData<String>
//        get() = _players

    private val _dumby = MutableLiveData(0)
    val dumby: LiveData<Int>
        get() = _dumby
//        get() = players.joinToString(separator = " \n")
    init {
//        getPlayerList()
    }

    fun getPlayerList() {
//        viewModelScope.launch {
//            _players.value = repository.playerList.first().joinToString("\n")
//            repository.playerList.collect { list ->
//                _players.value = list.joinToString(separator = "\n")
//            }
//        }
    }
    fun addMatchClicked() {
        val match = Match("Ada", Random.nextInt(0,8), "Dad", Random.nextInt(2,10))
        repository.addMatch(match)
        Log.d(TAG, "Repository has ${repository.matches.size} matches")
//        _players.value = repository.getPlayersSortedByComparator().joinToString(separator = "\n")
        _dumby.value = _dumby.value?.inc()
        Log.d(TAG, "_Dumby: ${_dumby.value.toString()}")
        Log.d(TAG, "Dumby: ${dumby.value.toString()}")
    }

}