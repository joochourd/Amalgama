package domain.battle

import domain.Army

class BattleResult(
    val winner: Army?,
    val loser: Army?,
    val winnerStrengh: Int,
    val loserStrengh: Int,
    private val resultDescription: String,
) {
    fun getResultDescription(): String {
        return "Battle Result: $resultDescription"
    }
}
