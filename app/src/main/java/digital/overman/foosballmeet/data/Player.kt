package digital.overman.foosballmeet.data

import android.util.Log

data class Player(
    val name: String,
    val matchesPlayed: MutableList<Match> = mutableListOf()
) {
    val matchCount
        get() = matchesPlayed.size

    val winCount: Int
        get() = matchesPlayed.count { didWinMatch(it) }

    fun addMatch(match: Match) { matchesPlayed.add(match) }

    fun didWinMatch(match: Match): Boolean = name == match.winnerName

    fun winPercentage(): Float = winCount.toFloat() / matchCount.toFloat()

    override fun toString(): String {
        return "$name has a ${winPercentage() * 100} win %"
    }
}
