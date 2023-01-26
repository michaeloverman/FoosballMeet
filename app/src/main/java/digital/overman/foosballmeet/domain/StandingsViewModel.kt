package digital.overman.foosballmeet.domain

import androidx.lifecycle.ViewModel
import digital.overman.foosballmeet.data.Player
import digital.overman.foosballmeet.data.PlayersRepository
import javax.inject.Inject

class StandingsViewModel @Inject constructor(private val repository: PlayersRepository) : ViewModel() {
    val players: List<Player> = repository.players
    val playerList = players.joinToString(separator = " \n")

    init {
        println("StandingsViewModel exists and has a $repository")
        println("${players.size} in this here view model")
    }
}