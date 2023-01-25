package digital.overman.foosballmeet.data

import javax.inject.Inject
import javax.inject.Singleton

class PlayersRepository @Inject constructor() {
    var players: MutableList<String> = mutableListOf("Ada", "Bob", "Cao", "Don", "Ice Cream")
}