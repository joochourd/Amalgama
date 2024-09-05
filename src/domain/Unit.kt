package domain

import java.util.UUID

interface Unit {
    val strength: Int
    val id: UUID
    val trainingCost: Int
    fun train()
}