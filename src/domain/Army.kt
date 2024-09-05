package domain

import domain.battle.BattleResult
import domain.units.Archer
import domain.units.Knight
import domain.units.Pikemen
import java.util.*

class Army(
    private val id: UUID,
    val pikemen: MutableList<Pikemen> = mutableListOf(),
    val archers: MutableList<Archer> = mutableListOf(),
    val knights: MutableList<Knight> = mutableListOf(),
    val battleHistory: MutableList<BattleResult> = mutableListOf(),
    private var gold: Int,
    val name: String
) {

    companion object {
        const val GOLD_WON_BY_BATTLE_AMOUNT = 100
    }

    fun trainUnit(id: UUID) {
        val unit = findUnitById(id)
        val cost = unit?.trainingCost
        if (cost != null && gold >= cost) {
            gold -= cost
            unit.train()
        } else {
            println("insufficient gold for training")
        }

    }

    fun totalStrength(): Int {
        return pikemen.sumOf { it.strength } +
                archers.sumOf { it.strength } +
                knights.sumOf { it.strength }
    }

    fun applyLossPenalty() {
        val allUnits = archers + pikemen + knights

        val strongestUnits = allUnits.sortedByDescending { it.strength }.take(2)

        strongestUnits.forEach { removeUnit(it) }
    }

    fun applyDrawPenalty() {
        val allUnits = archers + pikemen + knights

        val strongestUnits = allUnits.sortedByDescending { it.strength }.take(1)

        strongestUnits.forEach { removeUnit(it) }
    }

    fun applyWinReward() {
        gold += GOLD_WON_BY_BATTLE_AMOUNT
    }

    fun recordBattle(result: BattleResult) {
        battleHistory.add(result)
    }

    fun <T : Unit> transformUnit(unit: Transformable<T>) {
        if (gold >= unit.getTransformationCost()) {
            val newUnit = unit.transform()
            gold -= unit.getTransformationCost()
            removeUnit(unit as Unit)
            addUnit(newUnit)
        }
    }

    private fun findUnitById(id: UUID): Unit? {
        return pikemen.find { it.id == id }
            ?: archers.find { it.id == id }
            ?: knights.find { it.id == id }
    }

    private fun removeUnit(unit: Unit) {
        when (unit) {
            is Pikemen -> pikemen.remove(unit)
            is Archer -> archers.remove(unit)
            is Knight -> knights.remove(unit)
        }
    }

    private fun addUnit(unit: Unit) {
        when (unit) {
            is Pikemen -> pikemen.add(unit)
            is Archer -> archers.add(unit)
            is Knight -> knights.add(unit)
        }
    }
}