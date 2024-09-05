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
        val army = Army(
            name = "Chinese",
            id = UUID.randomUUID(),
            pikemen = buildPikemen(2),
            archers = buildArchers(25),
            knights = buildKnights(2),
            battleHistory = mutableListOf(),
            gold = INITIAL_GOLD,
        )

        return army
    }

    fun buildEnglishArmy(): Army {
        val army = Army(
            id = UUID.randomUUID(),
            pikemen = buildPikemen(10),
            archers = buildArchers(10),
            knights = buildKnights(10),
            battleHistory = mutableListOf(),
            gold = INITIAL_GOLD,
            name = "English",
        )

        return army
    }

    fun buildByzantinesArmy(): Army {
        val army = Army(
            id = UUID.randomUUID(),
            pikemen = buildPikemen(5),
            archers = buildArchers(8),
            knights = buildKnights(15),
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