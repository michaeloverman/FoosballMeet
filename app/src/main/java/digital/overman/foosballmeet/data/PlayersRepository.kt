package digital.overman.foosballmeet.data

import android.util.Log

object PlayersRepository {
    val players: MutableList<Player> = mutableListOf()
    val matches: MutableList<Match> = mutableListOf()

    fun addMatch(match: Match) {
        Log.d("REPO", "adding match")
        matches.add(match)

        val one: Player = getPlayer(match.p1name)
        val two: Player = getPlayer(match.p2name)

        // add match to each player
        one.addMatch(match)
        two.addMatch(match)

        println("This Repository exists and has ${matches.size} matches saved")
    }

    // This returns a player from the list, or updates the list with a new player
    private fun getPlayer(name: String): Player {
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
        return players.sortedWith(compareBy<Player> { it.winCount }.thenBy { it.winPercentage() } ).reversed()
    }

    fun getPlayersSortedByWinCount(): List<Player> = players.sortedBy { it.winCount }

}