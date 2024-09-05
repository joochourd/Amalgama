package domain.units

import builder.UnitBuilder
import domain.Transformable
import domain.Unit
import domain.units.Archer.Companion
import java.util.*

class Pikemen(
    override var strength: Int,
    override val id: UUID,
    override val trainingCost: Int,
    val unitBuilder: UnitBuilder
) : Unit, Transformable<Archer> {

    companion object {
        private val TRANSFORMATION_COST = 30
        private val TRAINING_STRENGH_GAIN = 3
    }

    override fun transform(): Archer {
        return unitBuilder.buildArcher()
    }

    override fun getTransformationCost(): Int {
        return TRANSFORMATION_COST
    }

    override fun train() {
        this.strength += TRAINING_STRENGH_GAIN
    }
}