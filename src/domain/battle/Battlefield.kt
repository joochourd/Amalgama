package domain.battle

import domain.Army

class Battlefield {
    fun fight(attacker: Army, defender: Army) {
        val attackerStrength = attacker.totalStrength()
        val defenderStrength = defender.totalStrength()

        val battleResult =  when {
            attackerStrength > defenderStrength -> {
                // Attacker wins
                attacker.applyWinReward()
                defender.applyLossPenalty()
                BattleResult(attacker, defender,attackerStrength, defenderStrength, "${attacker.name} Wins")
            }
            attackerStrength < defenderStrength -> {
                // Defender wins
                attacker.applyLossPenalty()
                defender.applyWinReward()
                BattleResult(defender, attacker,defenderStrength, attackerStrength, "${defender.name} Wins")
            }
            else -> {
                // Draw
                attacker.applyDrawPenalty()
                defender.applyDrawPenalty()
                BattleResult(null, null, attackerStrength, defenderStrength, "Draw")
            }
        }
        attacker.recordBattle(battleResult)
        defender.recordBattle(battleResult)
    }
}
