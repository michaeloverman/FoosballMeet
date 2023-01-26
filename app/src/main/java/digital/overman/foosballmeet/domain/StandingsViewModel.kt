package digital.overman.foosballmeet.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import digital.overman.foosballmeet.data.Match
import digital.overman.foosballmeet.data.PlayersRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

const val TAG = "StandingsViewModel"
class StandingsViewModel @Inject constructor(private val repository: PlayersRepository) : ViewModel() {
    val players
        get() = repository.getPlayersSortedByComparator()
    val playerList: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
//        get() = players.joinToString(separator = " \n")
    init {
        viewModelScope.launch {
            repository.playerList.collect { list ->
                playerList.value = list.joinToString(separator = "\n")
            }
        }
    }

    fun addMatchClicked() {
        val match = Match("Ada", Random.nextInt(0,8), "Dad", Random.nextInt(2,10))
        repository.addMatch(match)
    }

}