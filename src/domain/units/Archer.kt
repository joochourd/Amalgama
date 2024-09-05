package domain.units

import builder.UnitBuilder
import domain.Transformable
import domain.Unit
import java.util.*

class Archer(
    override var strength: Int,
    override val id: UUID,
    override val trainingCost: Int,
    val unitBuilder: UnitBuilder
) : Unit, Transformable<Knight> {

    companion object {
        private val TRANSFORMATION_COST = 40
        private val TRAINING_STRENGH_GAIN = 7
    }


    override fun transform(): Knight {
        return unitBuilder.buildKnight()
    }

    override fun getTransformationCost(): Int {
        return TRANSFORMATION_COST
    }

    override fun train() {
       this.strength += TRAINING_STRENGH_GAIN
    }
}