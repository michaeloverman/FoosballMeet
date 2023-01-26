package digital.overman.foosballmeet.data

import android.util.Log
import digital.overman.foosballmeet.data.PlayersRepository.players
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

object PlayersRepository {
    val players: MutableList<Player> = mutableListOf()
    val matches: MutableList<Match> = mutableListOf()

    val playerList: Flow<List<Player>> = flow { emit(players) }
    init {
        addMatch(Match("Ada", 5, "Bob", 6))
        addMatch(Match("Cal", 5, "Dad", 6))
        addMatch(Match("Ice Cream", 5, "Ada", 6))
        addMatch(Match("Cal", 5, "Bob", 6))

        println("This Repository exists and has ${matches.size} matches saved")
    }
    fun addMatch(match: Match) {
        Log.d("REPO", "adding match")
        matches.add(match)

        val one: Player = getPlayer(match.p1name)
        val two: Player = getPlayer(match.p2name)

        // add match to each player
        one.addMatch(match)
        two.addMatch(match)
    }

    fun getPlayer(name: String): Player {
        var p = players.singleOrNull { it.name == name }
        if (p == null) {
            Log.d("REPO", "Creating player $name")
            p = Player(name)
            players.add(p)
        }
        Log.d("REPO", "Returning player ${p.name}")
        return p
    }
    fun getPlayersSortedByPercentage(): List<Player> = players.sortedBy { it.winPercentage() }.reversed()

    fun getPlayersSortedByComparator(): List<Player> {
        return players.sortedWith(compareBy<Player> { it.winPercentage() }.thenBy { it.matchCount } ).reversed()
    }

    fun getPlayersSortedByWinCount(): List<Player> = players.sortedBy { it.winCount }

}