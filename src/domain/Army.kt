package domain

import domain.battle.BattleResult
import domain.units.Archer
import domain.units.Knight
import domain.units.Pikemen
import java.util.*

class Army(
    private val id: UUID,
    val units: MutableList<Unit>,
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
        return units.sumOf { it.strength }

    }

    fun applyLossPenalty() {
        val strongestUnits = units.sortedByDescending { it.strength }.take(2)

        strongestUnits.forEach { removeUnit(it) }
    }

    fun applyDrawPenalty() {
        val strongestUnits = units.sortedByDescending { it.strength }.take(1)

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
        return units.find { it.id == id }
    }

    private fun removeUnit(unit: Unit) {
        units.remove(unit)
    }

    private fun addUnit(unit: Unit) {
        units.add(unit)
    }
}