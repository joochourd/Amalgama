package domain.units

import domain.Unit
import java.util.*

class Knight(
    override var strength: Int,
    override val id: UUID,
    override val trainingCost: Int
) : Unit {
    companion object {
        private val TRAINING_STRENGH_GAIN = 3
    }

    override fun train() {
        this.strength += TRAINING_STRENGH_GAIN
    }

}