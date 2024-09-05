package builder

import domain.units.Archer
import domain.Army
import domain.units.Knight
import domain.units.Pikemen
import java.util.*

class ArmyBuilder(val unitBuilder: UnitBuilder) {

    companion object {
        const val INITIAL_GOLD = 1000
    }

    fun buildChineseArmy(): Army {
        val pikemen = buildPikemen(2)
        val archers = buildArchers(25)
        val knights = buildKnights(2)
        val army = Army(
            name = "Chinese",
            id = UUID.randomUUID(),
            units = (pikemen + archers + knights).toMutableList(),
            battleHistory = mutableListOf(),
            gold = INITIAL_GOLD,
        )

        return army
    }

    fun buildEnglishArmy(): Army {
        val pikemen = buildPikemen(10)
        val archers = buildArchers(10)
        val knights = buildKnights(10)
        val army = Army(
            id = UUID.randomUUID(),
            units = (pikemen + archers + knights).toMutableList(),
            battleHistory = mutableListOf(),
            gold = INITIAL_GOLD,
            name = "English",
        )

        return army
    }

    fun buildByzantinesArmy(): Army {
        val pikemen = buildPikemen(5)
        val archers = buildArchers(8)
        val knights = buildKnights(15)

        val army = Army(
            id = UUID.randomUUID(),
            units = (pikemen + archers + knights).toMutableList(),
            battleHistory = mutableListOf(),
            gold = INITIAL_GOLD,
            name = "Byzantines",
        )
        return army
    }

    private fun buildPikemen(amount: Int): MutableList<Pikemen> {
        val pikemen = mutableListOf<Pikemen>()
        repeat(amount) {
            pikemen.add(unitBuilder.buildPikemen())
        }
        return pikemen
    }

    private fun buildArchers(amount: Int): MutableList<Archer> {
        val archers = mutableListOf<Archer>()
        repeat(amount) {
            archers.add(unitBuilder.buildArcher())
        }
        return archers
    }
    private fun buildKnights(amount: Int): MutableList<Knight> {
        val knights = mutableListOf<Knight>()
        repeat(amount) {
            knights.add(unitBuilder.buildKnight())
        }
        return knights
    }
}