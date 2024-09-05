package builder

import domain.units.Archer
import domain.units.Knight
import domain.units.Pikemen
import java.util.*

class UnitBuilder {
    fun buildArcher(): Archer {
        return Archer(
            id = UUID.randomUUID(),
            strength = 10,
            trainingCost = 20,
            unitBuilder = this,
        )
    }
    fun buildKnight(): Knight {
        return Knight(
            id = UUID.randomUUID(),
            strength = 20,
            trainingCost = 30,
        )
    }
    fun buildPikemen(): Pikemen {
        return Pikemen(
            id = UUID.randomUUID(),
            strength = 5,
            trainingCost = 10,
            unitBuilder = this
        )
    }
}