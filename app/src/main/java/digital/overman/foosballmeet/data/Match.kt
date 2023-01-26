package digital.overman.foosballmeet.data

data class Match(
    val p1name: String,
    val p1score: Int,
    val p2name: String,
    val p2score: Int
) {
    val winnerScore: Int = if (p1score > p2score) p1score else p2score
    val winnerName: String = if (p1score > p2score) p1name else p2name
    val loserScore: Int = if (p1score > p2score) p2score else p1score
    val loserName: String = if (p1score > p2score) p2name else p1name
}
